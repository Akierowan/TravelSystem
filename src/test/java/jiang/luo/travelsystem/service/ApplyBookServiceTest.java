package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.impl.ApplyBookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

        when(applyBookMapper.insert(any(ApplyBook.class))).thenReturn(1);

        applyBookService.saveApplyBook(applyBookDTO);

        verify(applyBookMapper, times(1)).insert(any(ApplyBook.class));
    }

    @Test
    public void testUpdateApplyBook() {
        ApplyBookDTO applyBookDTO = new ApplyBookDTO();
        applyBookDTO.setId(1);
        applyBookDTO.setName("Updated Test");

        when(applyBookMapper.updateById(any(ApplyBook.class))).thenReturn(1);

        applyBookService.updateApplyBook(applyBookDTO);

        verify(applyBookMapper, times(1)).updateById(any(ApplyBook.class));
    }

    @Test
    public void testPageQuery() {
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);
        pageQueryDTO.setParam("Test");

        Page<ApplyBook> page = new Page<>(1, 10);
        page.setRecords(Collections.singletonList(new ApplyBook()));

        when(applyBookMapper.selectPage(any(Page.class), any(QueryWrapper.class))).thenReturn(page);

        PageResult result = applyBookService.pageQuery(pageQueryDTO);

        assert result.getRecords().size() == 1;
    }

    @Test
    public void testCancelParticipation() {
        ApplyBook applyBook = new ApplyBook();
        applyBook.setId(4);
        applyBook.setDepartDate(LocalDate.now().plusDays(20));
        applyBook.setPathNumber("12345");
        applyBook.setBirthday(LocalDate.now().minusYears(30));
        applyBook.setApplyInfoId(1);

        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setDepositRatio(0.5);
        applyInfo.setBalanceStatus(0);

        PathBook pathBook = new PathBook();
        pathBook.setAdultPrice(1000.0);
        pathBook.setChildPrice(500.0);

        when(applyBookMapper.selectById(4)).thenReturn(applyBook);
        when(applyInfoMapper.selectById(1)).thenReturn(applyInfo);
        when(pathBookMapper.selectOne(any(QueryWrapper.class))).thenReturn(pathBook);
        when(financeBookMapper.insert(any(FinanceBook.class))).thenReturn(1);

        applyBookService.cancelParticipation(4);

        verify(applyBookMapper, times(1)).selectById(4);
        verify(applyBookMapper, times(1)).deleteById(4);
        verify(financeBookMapper, times(1)).insert(any(FinanceBook.class));
    }
}