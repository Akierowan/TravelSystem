package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.FinanceBook;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;


public interface FinanceBookService extends IService<FinanceBook> {

    /**
     * 分页查询
     */
    public PageResult pageQuery(PageQueryDTO pageQueryDTO);
}
