package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jiang.luo.travelsystem.pojo.FinanceBook;
import com.baomidou.mybatisplus.extension.service.IService;


/**
* @author lenovo
* @description 针对表【finance_book】的数据库操作Service
* @createDate 2024-05-26 14:49:04
*/
public interface FinanceBookService extends IService<FinanceBook> {
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<FinanceBook> pageQuery(int pageNum, int pageSize);
}
