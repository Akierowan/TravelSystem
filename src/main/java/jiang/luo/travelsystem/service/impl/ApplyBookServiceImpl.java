package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.ApplyBookService;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
* @author lenovo
* @description 针对表【apply_book】的数据库操作Service实现
* @createDate 2024-05-25 12:44:08
*/
@Service
public class ApplyBookServiceImpl extends ServiceImpl<ApplyBookMapper, ApplyBook>
    implements ApplyBookService{

    @Autowired
    ApplyBookMapper applyBookMapper;
    @Autowired
    FinanceBookMapper financeBookMapper;
    @Autowired
    ApplyInfoMapper applyInfoMapper;
    @Autowired
    PathBookMapper pathBookMapper;

    /**
     * 将新的申请书，插入到数据库中
     * @param applyBookDTO
     */
    @Override
    public void saveApplyBook(ApplyBookDTO applyBookDTO) {
        ApplyBook applyBook = new ApplyBook();

        BeanUtils.copyProperties(applyBookDTO, applyBook);

        applyBook.setUpdateTime(LocalDateTime.now());

        applyBookMapper.insert(applyBook);


    }

    /**
     * 更改申请书
     * @param applyBookDTO
     */
    @Override
    public void updateApplyBook(ApplyBookDTO applyBookDTO) {
        ApplyBook applyBook = new ApplyBook();
        BeanUtils.copyProperties(applyBookDTO, applyBook);
        applyBookMapper.updateById(applyBook);
    }

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(PageQueryDTO pageQueryDTO) {
        Page<ApplyBook> page = new Page<>(pageQueryDTO.getPageNum(), pageQueryDTO.getPageSize());
        QueryWrapper<ApplyBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", pageQueryDTO.getParam());
        Page<ApplyBook> applyBookPage = applyBookMapper.selectPage(page, queryWrapper);
        return new PageResult(applyBookPage.getTotal(), applyBookPage.getRecords());
    }


    /**
     * 取消参加（单人）
     * @param id
     */
    @Override
    @Transactional
    public void cancelParticipation(Integer id) {
        ApplyBook applyBook = applyBookMapper.selectById(id);
        // 删除对应申请书
        applyBookMapper.deleteById(id);

        // 添加财务流水
        long daysDiff = ChronoUnit.DAYS.between(LocalDate.now(), applyBook.getDepartDate());
        double amount;
        if (daysDiff <= 0) {
            amount = 0;
        } else {
            ApplyInfo applyInfo = applyInfoMapper.selectById(applyBook.getApplyInfoId());
            QueryWrapper<PathBook> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("path_number", applyBook.getPathNumber());
            PathBook pathBook = pathBookMapper.selectOne(queryWrapper);
            // 判断是否成年
            int age = Period.between(applyBook.getBirthday(), LocalDate.now()).getYears();
            double origin = age < 18 ? pathBook.getChildPrice() : pathBook.getAdultPrice();
            if (applyInfo.getBalanceStatus() == 0) {  //未交余款，退订金部分
                origin *= applyInfo.getDepositRatio();
            }
            if (daysDiff >= 30) {
                amount = origin;
            } else if (daysDiff >= 10) {
                amount = origin * 0.2;
            } else {
                amount = origin * 0.5;
            }
        }
        FinanceBook financeBook = new FinanceBook();
        financeBook.setAmount(amount);
        financeBook.setType(2);
        financeBook.setApplyInfoId(id);
        financeBook.setUpdateTime(LocalDateTime.now());
        financeBookMapper.insert(financeBook);
    }
}




