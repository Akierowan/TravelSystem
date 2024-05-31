package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.ApplyInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ApplyInfoMapperTest {

    @Autowired
    private ApplyInfoMapper applyInfoMapper;

    private ApplyInfo testApplyInfo;

    @BeforeEach
    public void setUp() {
        testApplyInfo = new ApplyInfo();
        testApplyInfo.setDeposit(100.0);
        testApplyInfo.setTotalPrice(1000.0);
        testApplyInfo.setDepositStatus(0);
        testApplyInfo.setCancelStatus(0);
        testApplyInfo.setPayDeadline(LocalDate.now().plusDays(30));
        testApplyInfo.setPaymentSendDate(LocalDate.now());
        testApplyInfo.setBalanceStatus(0);
        testApplyInfo.setPrincipalName("John Doe");
        testApplyInfo.setUpdateTime(LocalDateTime.now());
        testApplyInfo.setDepositRatio(0.1);
        testApplyInfo.setDepartDate(LocalDate.now().plusDays(60));
    }

    @Test
    public void testInsert() {
        int result = applyInfoMapper.insert(testApplyInfo);
        assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        applyInfoMapper.insert(testApplyInfo);
        ApplyInfo fetchedApplyInfo = applyInfoMapper.selectById(testApplyInfo.getId());
        assertNotNull(fetchedApplyInfo);
        assertEquals("John Doe", fetchedApplyInfo.getPrincipalName());
    }

    @Test
    public void testUpdate() {
        applyInfoMapper.insert(testApplyInfo);
        testApplyInfo.setPrincipalName("John Updated");
        applyInfoMapper.updateById(testApplyInfo);
        ApplyInfo updatedApplyInfo = applyInfoMapper.selectById(testApplyInfo.getId());
        assertEquals("John Updated", updatedApplyInfo.getPrincipalName());
    }

    @Test
    public void testDelete() {
        applyInfoMapper.insert(testApplyInfo);
        int result = applyInfoMapper.deleteById(testApplyInfo.getId());
        assertEquals(1, result);
        ApplyInfo deletedApplyInfo = applyInfoMapper.selectById(testApplyInfo.getId());
        assertNull(deletedApplyInfo);
    }
}
