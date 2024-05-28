package jiang.luo.travelsystem.service.impl;

import cn.hutool.core.date.DateTime;
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

import java.util.Date;
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
        long daysDiff = (firstApplyDTO.getDepartureDate().getTime() - new Date().getTime()) / (24 * 60 * 60 * 1000);
        double deposit = totalPrice;
        if (daysDiff >= 60) {
            deposit *= 0.1;
        } else if (daysDiff >= 30) {
            deposit *= 0.2;
        }
        ApplyInfo applyInfo = ApplyInfo.builder()
                .principalName(firstApplyDTO.getPrincipalName())
                .deposit(deposit)
                .totalPrice(totalPrice)
                .updateTime(new DateTime())
                .build();
        applyInfoMapper.insert(applyInfo);
        return applyInfo.getId();
    }

    /**
     * 根据负责人姓名查找订单信息
     * @param name
     * @return
     */
    @Override
    public List<ApplyInfo> getByName(String name) {
        QueryWrapper<ApplyInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("principal_name", name);
        return applyInfoMapper.selectList(queryWrapper);
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
        applyInfo.setUpdateTime(new DateTime());
        applyInfoMapper.updateById(applyInfo);

        //添加本次交易到财务报表
        applyInfo = applyInfoMapper.selectById(id);
        FinanceBook financeBook = new FinanceBook();
        financeBook.setAmount(applyInfo.getDeposit());
        financeBook.setUpdateTime(new DateTime());
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
        // 删除相关的所有旅游申请书
        QueryWrapper<ApplyBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("apply_book_id", id);
        applyBookMapper.delete(queryWrapper);

        // 更改ApplyInfo的cancelStatus
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(id);
        applyInfo.setCancelStatus(1);
        applyInfoMapper.updateById(applyInfo);

        // 添加财务流水到FinanceBook（退款） TODO 计算金额
        double amount = 88;
        FinanceBook financeBook = new FinanceBook();
        financeBook.setAmount(amount);
        financeBook.setType(2);
        financeBook.setOrderInfoId(id);
        financeBook.setUpdateTime(new DateTime());
        financeBookMapper.insert(financeBook);
    }


}




