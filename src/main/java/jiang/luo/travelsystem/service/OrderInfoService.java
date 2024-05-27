package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【order_info】的数据库操作Service
* @createDate 2024-05-26 18:23:23
*/
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 第一次提交申请
     * @param firstApplyDTO
     * @return
     */
    Integer saveFirstApply(FirstApplyDTO firstApplyDTO);


    /**
     * 根据名字来查找订单信息
     * @param name
     * @return
     */
    List<OrderInfo> getByName(String name);


//     * TODO 支付订金

    void payDeposit(Integer id);

}
