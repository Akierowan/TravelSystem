package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.pojo.FinanceBook;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.service.FinanceBookService;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【finance_book】的数据库操作Service实现
* @createDate 2024-05-26 14:49:04
*/
@Service
public class FinanceBookServiceImpl extends ServiceImpl<FinanceBookMapper, FinanceBook>
    implements FinanceBookService{

    @Autowired
    private FinanceBookMapper financeBookMapper;

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(PageQueryDTO pageQueryDTO) {
        Page<FinanceBook> page = new Page<>(pageQueryDTO.getPageNum(), pageQueryDTO.getPageSize());
        // TODO 条件搜索
        //QueryWrapper<FinanceBook> queryWrapper = new QueryWrapper<>();

        Page<FinanceBook> financeBookPage = financeBookMapper.selectPage(page, null);
        return new PageResult(financeBookPage.getTotal(), financeBookPage.getRecords());
    }
}




