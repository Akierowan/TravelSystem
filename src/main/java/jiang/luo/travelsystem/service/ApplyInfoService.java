package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.ApplyInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;

public interface ApplyInfoService extends IService<ApplyInfo> {
    /**
     * 第一次提交申请
     */
    Integer saveFirstApply(FirstApplyDTO firstApplyDTO);

    /**
     * 支付订金
     */
    void payDeposit(Integer id);


    /**
     * 分页查询
     */
    PageResult pageQuery(PageQueryDTO pageQueryDTO);

    /**
     * 取消整个申请
     */
    void cancelApply(Integer id);

    /**
     * 支付余款
     */
    void payBalance(Integer id);

}
