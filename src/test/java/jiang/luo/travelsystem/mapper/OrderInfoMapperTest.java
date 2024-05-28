package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.ApplyInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderInfoMapperTest {

    @Autowired
    private ApplyInfoMapper applyInfoMapper;

    @Test
    public void testInsert() {
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setDeposit(1000.0);
        applyInfo.setApplyBookId(1);
        applyInfo.setTotalPrice(2000.0);
        applyInfo.setDepositStatus(1);
        applyInfo.setCancelStatus(0);
        applyInfo.setPayDeadline(new Date());
        applyInfo.setPaymentSendDate(new Date());
        applyInfo.setBalanceStatus(1);

        int result = applyInfoMapper.insert(applyInfo);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        ApplyInfo applyInfo = applyInfoMapper.selectById(1);
        Assertions.assertNotNull(applyInfo);
        System.out.println(applyInfo);
    }

    @Test
    public void testUpdate() {
        ApplyInfo applyInfo = applyInfoMapper.selectById(1);
        applyInfo.setDeposit(1500.0);
        int result = applyInfoMapper.updateById(applyInfo);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = applyInfoMapper.deleteById(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<ApplyInfo> applyInfos = applyInfoMapper.selectList(null);
        Assertions.assertNotNull(applyInfos);
        applyInfos.forEach(System.out::println);
    }
}
