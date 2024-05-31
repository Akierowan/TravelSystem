package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.mapper.FinanceBookMapper;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.impl.ApplyInfoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
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
        firstApplyDTO.setPathNumber("PN123");
        firstApplyDTO.setAdultNumber(2);
        firstApplyDTO.setChildNumber(1);
        firstApplyDTO.setDepartDate(LocalDate.now().plusDays(45));
        firstApplyDTO.setPrincipalName("John Doe");

        PathBook pathBook = new PathBook();
        pathBook.setAdultPrice(300.0);
        pathBook.setChildPrice(150.0);

        when(pathBookMapper.selectOne(any(QueryWrapper.class))).thenReturn(pathBook);
        doAnswer(invocation -> {
            ApplyInfo arg = invocation.getArgument(0);
            arg.setId(1);
            return null;
        }).when(applyInfoMapper).insert(any(ApplyInfo.class));

        Integer applyInfoId = applyInfoService.saveFirstApply(firstApplyDTO);

        assertNotNull(applyInfoId);
        assertEquals(1, applyInfoId);
        verify(applyInfoMapper, times(1)).insert(any(ApplyInfo.class));
    }

    @Test
    public void testPayDeposit() {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(1);
        applyInfo.setDeposit(150.0);
        applyInfo.setTotalPrice(750.0);
        applyInfo.setBalanceStatus(0);

        when(applyInfoMapper.selectById(1)).thenReturn(applyInfo);

        applyInfoService.payDeposit(1);

        verify(applyInfoMapper, times(1)).updateById(any(ApplyInfo.class));
        verify(financeBookMapper, times(1)).insert(any(FinanceBook.class));
    }

    @Test
    public void testCancelApply() {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(1);
        applyInfo.setTotalPrice(1000.0);
        applyInfo.setDeposit(100.0);
        applyInfo.setBalanceStatus(0);
        applyInfo.setDepartDate(LocalDate.now().plusDays(20));

        when(applyInfoMapper.selectById(1)).thenReturn(applyInfo);

        applyInfoService.cancelApply(1);

        verify(applyBookMapper, times(1)).delete(any(QueryWrapper.class));
        verify(applyInfoMapper, times(1)).updateById(any(ApplyInfo.class));
        verify(financeBookMapper, times(1)).insert(any(FinanceBook.class));
    }

    @Test
    public void testPayBalance() {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(1);
        applyInfo.setDeposit(100.0);
        applyInfo.setTotalPrice(500.0);

        when(applyInfoMapper.selectById(1)).thenReturn(applyInfo);

        applyInfoService.payBalance(1);

        verify(applyInfoMapper, times(1)).updateById(any(ApplyInfo.class));
        verify(financeBookMapper, times(1)).insert(any(FinanceBook.class));
    }

    @Test
    public void testSendPayment() {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setId(1);
        applyInfo.setPayDeadline(LocalDate.now().plusDays(5));
        applyInfo.setPaymentSendDate(null);

        when(applyInfoMapper.selectById(1)).thenReturn(applyInfo);

        applyInfoService.sendPayment(1);

        verify(applyInfoMapper, times(1)).updateById(any(ApplyInfo.class));
    }


    @Test
    public void testPageQuery() {
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);
        pageQueryDTO.setParam("John");

        Page<ApplyInfo> page = new Page<>(1, 10);
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setPrincipalName("John Doe");
        page.setRecords(Collections.singletonList(applyInfo));
        page.setTotal(1);

        when(applyInfoMapper.selectPage(any(Page.class), any(QueryWrapper.class))).thenReturn(page);

        PageResult result = applyInfoService.pageQuery(pageQueryDTO);

        assertEquals(1, result.getTotal());
        assertEquals(1, result.getRecords().size());
        assertEquals(applyInfo, result.getRecords().get(0));

        verify(applyInfoMapper, times(1)).selectPage(any(Page.class), any(QueryWrapper.class));
    }


}
