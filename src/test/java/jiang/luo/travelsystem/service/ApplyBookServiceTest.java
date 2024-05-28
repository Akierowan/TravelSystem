package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.impl.ApplyBookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.Collections;

@SpringBootTest
public class ApplyBookServiceTest {

    @Mock
    private ApplyBookMapper applyBookMapper;

    @Mock
    private FinanceBookMapper financeBookMapper;

    @Mock
    private ApplyInfoMapper applyInfoMapper;

    @Mock
    private PathBookMapper pathBookMapper;

    @InjectMocks
    private ApplyBookServiceImpl applyBookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveApplyBook() {
        ApplyBookDTO applyBookDTO = new ApplyBookDTO();
        applyBookDTO.setName("Test");

        ApplyBook applyBook = new ApplyBook();
        Mockito.when(applyBookMapper.insert(Mockito.any(ApplyBook.class))).thenReturn(1);

        applyBookService.saveApplyBook(applyBookDTO);

        Mockito.verify(applyBookMapper, Mockito.times(1)).insert(Mockito.any(ApplyBook.class));
    }

    @Test
    public void testUpdateApplyBook() {
        ApplyBookDTO applyBookDTO = new ApplyBookDTO();
        applyBookDTO.setId(1);
        applyBookDTO.setName("Updated Test");

        ApplyBook applyBook = new ApplyBook();
        Mockito.when(applyBookMapper.updateById(Mockito.any(ApplyBook.class))).thenReturn(1);

        applyBookService.updateApplyBook(applyBookDTO);

        Mockito.verify(applyBookMapper, Mockito.times(1)).updateById(Mockito.any(ApplyBook.class));
    }

    @Test
    public void testPageQuery() {
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);
        pageQueryDTO.setParam("Test");

        Page<ApplyBook> page = new Page<>(1, 10);
        page.setRecords(Collections.singletonList(new ApplyBook()));

        QueryWrapper<ApplyBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "Test");
        Mockito.when(applyBookMapper.selectPage(Mockito.any(Page.class), Mockito.any(QueryWrapper.class))).thenReturn(page);

        Assertions.assertEquals(1, applyBookService.pageQuery(pageQueryDTO).getRecords().size());
    }

    @Test
    public void testCancelParticipation() {
        ApplyBook applyBook = new ApplyBook();
        applyBook.setId(1);
        applyBook.setDepartDate(LocalDateTime.now().toLocalDate().plusDays(20));
        applyBook.setPathNumber("12345");

        Mockito.when(applyBookMapper.selectById(1)).thenReturn(applyBook);
        Mockito.when(applyInfoMapper.selectById(applyBook.getApplyInfoId())).thenReturn(new ApplyInfo());
        Mockito.when(pathBookMapper.selectOne(Mockito.any(QueryWrapper.class))).thenReturn(new PathBook());
        Mockito.when(financeBookMapper.insert(Mockito.any())).thenReturn(1);

        applyBookService.cancelParticipation(1);

        Mockito.verify(applyBookMapper, Mockito.times(1)).selectById(1);
        Mockito.verify(applyBookMapper, Mockito.times(1)).deleteById(1);
        Mockito.verify(financeBookMapper, Mockito.times(1)).insert(Mockito.any());
    }
}
