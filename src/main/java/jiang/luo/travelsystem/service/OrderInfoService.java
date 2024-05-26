package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lenovo
* @description 针对表【order_info】的数据库操作Service
* @createDate 2024-05-26 18:23:23
*/
public interface OrderInfoService extends IService<OrderInfo> {

    //第一次提交申请
    void saveFirstApply(FirstApplyDTO firstApplyDTO);


}
