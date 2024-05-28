package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.ApplyInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;

import java.util.List;

/**
* @author lenovo
* @description 针对表【order_info】的数据库操作Service
* @createDate 2024-05-26 18:23:23
*/
public interface ApplyInfoService extends IService<ApplyInfo> {

    /**
     * 第一次提交申请
     * @param firstApplyDTO
     * @return
     */
    Integer saveFirstApply(FirstApplyDTO firstApplyDTO);

    /**
     * 支付订金
     * @param id
     */
    void payDeposit(Integer id);


    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    PageResult pageQuery(PageQueryDTO pageQueryDTO);

    /**
     * 取消整个申请
     * @param id
     */
    void cancelApply(Integer id);

}
