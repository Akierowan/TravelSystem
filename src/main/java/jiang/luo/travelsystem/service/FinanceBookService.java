package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jiang.luo.travelsystem.pojo.FinanceBook;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.PageResult;


/**
* @author lenovo
* @description 针对表【finance_book】的数据库操作Service
* @createDate 2024-05-26 14:49:04
*/
public interface FinanceBookService extends IService<FinanceBook> {

    public PageResult pageQuery(int pageNum, int pageSize);
}
