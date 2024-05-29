package jiang.luo.travelsystem.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.impl.ApplyInfoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ApplyInfoServiceTest {

    @Mock
    private ApplyInfoMapper applyInfoMapper;

    @Mock
    private PathBookMapper pathBookMapper;

    @Mock
    private FinanceBookMapper financeBookMapper;

    @Mock
    private ApplyBookMapper applyBookMapper;

    @InjectMocks
    private ApplyInfoServiceImpl applyInfoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveFirstApply() {
        FirstApplyDTO firstApplyDTO = new FirstApplyDTO();
        firstApplyDTO.setPathNumber("123");
        firstApplyDTO.setAdultNumber(2);
        firstApplyDTO.setChildNumber(1);
        firstApplyDTO.setDepartDate(LocalDate.now().plusDays(20));
        firstApplyDTO.setPrincipalName("John Doe");

        // 模拟 PathBook 对象
        PathBook pathBook = new PathBook();
        pathBook.setAdultPrice(100.0);
        pathBook.setChildPrice(50.0);

        // 设置模拟查询条件
        QueryWrapper<PathBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("path_number", firstApplyDTO.getPathNumber());
        queryWrapper.eq("delete_status", 0);

        // 模拟查询 PathBook
        when(pathBookMapper.selectOne(queryWrapper)).thenReturn(pathBook);

        Integer applyInfoId = applyInfoService.saveFirstApply(firstApplyDTO);

        verify(applyInfoMapper, times(1)).insert(any(ApplyInfo.class));
    }


    @Test
    public void testPayDeposit() {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(1);
        applyInfo.setDeposit(500.0);

        when(applyInfoMapper.selectById(1)).thenReturn(applyInfo);

        applyInfoService.payDeposit(1);

        verify(applyInfoMapper, times(1)).updateById(any(ApplyInfo.class));
        verify(financeBookMapper, times(1)).insert(any(FinanceBook.class));
    }

    @Test
    public void testPageQuery() {
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);
        pageQueryDTO.setParam("John Doe");

        Page<ApplyInfo> page = new Page<>(1, 10);
        page.setRecords(Collections.singletonList(new ApplyInfo()));

        when(applyInfoMapper.selectPage(any(Page.class), any(QueryWrapper.class))).thenReturn(page);

        PageResult result = applyInfoService.pageQuery(pageQueryDTO);

        assert result.getRecords().size() == 1;
    }

    @Test
    public void testCancelApply() {
        ApplyBook applyBook = new ApplyBook();
        applyBook.setDepartDate(LocalDate.now().plusDays(20));
        applyBook.setApplyInfoId(1); // 设置 applyInfoId
        List<ApplyBook> applyBooks = Collections.singletonList(applyBook);

        when(applyBookMapper.selectList(any(QueryWrapper.class))).thenReturn(applyBooks);

        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setBalanceStatus(0);
        applyInfo.setDeposit(100.0);
        applyInfo.setTotalPrice(500.0);

        when(applyInfoMapper.selectById(1)).thenReturn(applyInfo);

        applyInfoService.cancelApply(1);

        verify(applyBookMapper, times(1)).delete(any(QueryWrapper.class));
        verify(applyInfoMapper, times(1)).updateById(any(ApplyInfo.class));
        verify(financeBookMapper, times(1)).insert(any(FinanceBook.class));
    }

}
