package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.ApplyBook;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.ApplyBookDTO;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;

public interface ApplyBookService extends IService<ApplyBook> {
    /**
     * 新增申请书
     */
    void saveApplyBook(ApplyBookDTO applyBookDTO);

    /**
     * 更改申请书
     */
    void updateApplyBook(ApplyBookDTO applyBookDTO);

    /**
     * 分页查询
     */
    PageResult pageQuery(PageQueryDTO pageQueryDTO);

    /**
     * 取消参加（单人）
     */
    void cancelParticipation(Integer id);
}
