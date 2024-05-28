package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.ApplyInfoService;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
* @author lenovo
* @description 针对表【order_info】的数据库操作Service实现
* @createDate 2024-05-26 18:23:23
*/
@Service
public class ApplyInfoServiceImpl extends ServiceImpl<ApplyInfoMapper, ApplyInfo>
    implements ApplyInfoService {

    @Autowired
    private ApplyInfoMapper applyInfoMapper;
    @Autowired
    private PathBookMapper pathBookMapper;
    @Autowired
    private FinanceBookMapper financeBookMapper;
    @Autowired
    private ApplyBookMapper applyBookMapper;

    /**
     * 第一步申请
     * @param firstApplyDTO
     */
    @Override
    public Integer saveFirstApply(FirstApplyDTO firstApplyDTO) {
        Integer pathId = firstApplyDTO.getPathId();
        PathBook path = pathBookMapper.selectById(pathId);
        double totalPrice = path.getAdultPrice() * firstApplyDTO.getAdultNumber() + path.getChildPrice() * firstApplyDTO.getChildNumber();
        // 计算距离出发日期的天数
        long daysDiff = ChronoUnit.DAYS.between(firstApplyDTO.getDepartureDate(), LocalDate.now());
        double depositRatio;
        if (daysDiff >= 60) {
            depositRatio = 0.1;
        } else if (daysDiff >= 30) {
            depositRatio = 0.2;
        } else {
            depositRatio = 1;
        }
        double deposit = totalPrice * depositRatio;
        ApplyInfo applyInfo = ApplyInfo.builder()
                .principalName(firstApplyDTO.getPrincipalName())
                .deposit(deposit)
                .totalPrice(totalPrice)
                .updateTime(LocalDateTime.now())
                .depositRatio(depositRatio)
                .build();
        applyInfoMapper.insert(applyInfo);
        return applyInfo.getId();
    }

    /**
     * 支付订金
     * @param id
     */
    @Override
    @Transactional
    public void payDeposit(Integer id) {
        // 修改订单表中的订单支付状态
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setDepositStatus(1);
        applyInfo.setId(id);
        applyInfo.setUpdateTime(LocalDateTime.now());
        applyInfoMapper.updateById(applyInfo);

        //添加本次交易到财务报表
        applyInfo = applyInfoMapper.selectById(id);
        FinanceBook financeBook = new FinanceBook();
        financeBook.setAmount(applyInfo.getDeposit());
        financeBook.setUpdateTime(LocalDateTime.now());
        financeBook.setType(0);
        financeBookMapper.insert(financeBook);
    }

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(PageQueryDTO pageQueryDTO) {
        Page<ApplyInfo> page = new Page<>(pageQueryDTO.getPageNum(), pageQueryDTO.getPageSize());
        QueryWrapper<ApplyInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("principal_name", pageQueryDTO.getParam());
        Page<ApplyInfo> applyInfoPage = applyInfoMapper.selectPage(page, queryWrapper);
        return new PageResult(applyInfoPage.getTotal(), applyInfoPage.getRecords());
    }

    /**
     * 取消整个申请
     * @param id
     */
    @Override
    @Transactional
    public void cancelApply(Integer id) {
        QueryWrapper<ApplyBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("apply_info_id", id);
        List<ApplyBook> applyBooks = applyBookMapper.selectList(queryWrapper);
        // 删除相关的所有旅游申请书
        applyBookMapper.delete(queryWrapper);

        // 更改ApplyInfo的cancelStatus
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(id);
        applyInfo.setCancelStatus(1);
        applyInfoMapper.updateById(applyInfo);

        // 添加财务流水到FinanceBook（退款）
        applyInfo = applyInfoMapper.selectById(id);
        double origin = applyInfo.getBalanceStatus() == 0 ? applyInfo.getDeposit() : applyInfo.getTotalPrice();
        long daysDiff = ChronoUnit.DAYS.between(LocalDate.now(), applyBooks.get(0).getDepartDate());
        double amount;
        if (daysDiff >= 30) {
            amount = origin;
        } else if (daysDiff >= 10) {
            amount = origin * 0.2;
        } else {
            amount = origin * 0.5;
        }
        FinanceBook financeBook = new FinanceBook();
        financeBook.setAmount(amount);
        financeBook.setType(2);
        financeBook.setApplyInfoId(id);
        financeBook.setUpdateTime(LocalDateTime.now());
        financeBookMapper.insert(financeBook);
    }


}




