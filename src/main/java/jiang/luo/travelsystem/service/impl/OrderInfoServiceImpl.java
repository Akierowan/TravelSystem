package jiang.luo.travelsystem.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.FinanceBook;
import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.OrderInfo;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.service.OrderInfoService;
import jiang.luo.travelsystem.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author lenovo
* @description 针对表【order_info】的数据库操作Service实现
* @createDate 2024-05-26 18:23:23
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService{

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private PathBookMapper pathBookMapper;
    @Autowired
    private FinanceBookMapper financeBookMapper;

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
        OrderInfo orderInfo = OrderInfo.builder()
                .name(firstApplyDTO.getName())
                .deposit(deposit)
                .totalPrice(totalPrice)
                .build();
        orderInfoMapper.insert(orderInfo);
        return orderInfo.getId();
    }

    /**
     * 根据姓名查找订单信息
     * @param name
     * @return
     */
    @Override
    public List<OrderInfo> getByName(String name) {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return orderInfoMapper.selectList(queryWrapper);
    }

    /**
     * 支付订金
     * @param id
     */
    @Override
    public void payDeposit(Integer id) {
        // 修改订单表中的订单支付状态
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setDepositStatus(1);
        orderInfo.setId(id);
        orderInfoMapper.updateById(orderInfo);

        //添加本次交易到财务报表
        orderInfo = orderInfoMapper.selectById(id);
        FinanceBook financeBook = new FinanceBook();
        financeBook.setAmount(orderInfo.getDeposit());
        financeBook.setUpdateTime(new DateTime());
        financeBook.setType(0);
        financeBookMapper.insert(financeBook);
    }


}




