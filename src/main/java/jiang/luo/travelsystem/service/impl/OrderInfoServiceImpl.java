package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.OrderInfo;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.service.OrderInfoService;
import jiang.luo.travelsystem.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author lenovo
* @description 针对表【order_info】的数据库操作Service实现
* @createDate 2024-05-26 18:23:23
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService{

    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    PathBookMapper pathBookMapper;

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
}




