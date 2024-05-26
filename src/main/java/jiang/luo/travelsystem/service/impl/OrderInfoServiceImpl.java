package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.pojo.OrderInfo;
import jiang.luo.travelsystem.service.OrderInfoService;
import jiang.luo.travelsystem.mapper.OrderInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【order_info】的数据库操作Service实现
* @createDate 2024-05-26 14:33:07
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService{

}




