package jiang.luo.travelsystem.service;


import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.pojo.FinanceBook;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.service.impl.FinanceBookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
        // 设置分页查询参数
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);

        // 创建一个包含 FinanceBook 记录的 Page 对象
        Page<FinanceBook> page = new Page<>(1, 10);
        FinanceBook financeBook = new FinanceBook();
        page.setRecords(Collections.singletonList(financeBook));
        page.setTotal(1);

        // 模拟 financeBookMapper.selectPage 的行为
        when(financeBookMapper.selectPage(any(Page.class), isNull())).thenReturn(page);

        // 调用被测试的方法
        PageResult result = financeBookService.pageQuery(pageQueryDTO);

        // 验证结果
        assertEquals(1, result.getTotal());
        assertEquals(1, result.getRecords().size());
        assertEquals(financeBook, result.getRecords().get(0));

        // 验证 selectPage 方法被调用了一次
        verify(financeBookMapper, times(1)).selectPage(any(Page.class), isNull());
    }
}
