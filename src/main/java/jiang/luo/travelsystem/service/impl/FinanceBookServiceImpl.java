package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.pojo.FinanceBook;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.service.FinanceBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceBookServiceImpl extends ServiceImpl<FinanceBookMapper, FinanceBook>
    implements FinanceBookService{

    @Autowired
    private FinanceBookMapper financeBookMapper;

    /**
     * 分页查询
     */
    @Override
    public PageResult pageQuery(PageQueryDTO pageQueryDTO) {
        Page<FinanceBook> page = new Page<>(pageQueryDTO.getPageNum(), pageQueryDTO.getPageSize());
        Page<FinanceBook> financeBookPage = financeBookMapper.selectPage(page, null);
        return new PageResult(financeBookPage.getTotal(), financeBookPage.getRecords());
    }
}




