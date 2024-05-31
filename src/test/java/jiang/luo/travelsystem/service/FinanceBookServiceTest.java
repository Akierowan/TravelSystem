package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.pojo.FinanceBook;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.service.impl.FinanceBookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class FinanceBookServiceTest {

    @Mock
    private FinanceBookMapper financeBookMapper;

    @InjectMocks
    private FinanceBookServiceImpl financeBookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPageQuery() {
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);

        Page<FinanceBook> page = new Page<>(1, 10);
        FinanceBook financeBook = new FinanceBook();
        financeBook.setId(1);
        financeBook.setAmount(1000.0);
        financeBook.setType(0);
        page.setRecords(Collections.singletonList(financeBook));
        page.setTotal(1);

        when(financeBookMapper.selectPage(any(Page.class), any(QueryWrapper.class))).thenReturn(page);

        PageResult result = financeBookService.pageQuery(pageQueryDTO);

        assertEquals(1, result.getTotal());
        assertEquals(1, result.getRecords().size());
        assertEquals(financeBook, result.getRecords().get(0));

        verify(financeBookMapper, times(1)).selectPage(any(Page.class), any(QueryWrapper.class));
    }
}
