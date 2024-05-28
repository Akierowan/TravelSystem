package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.ApplyInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ApplyInfoMapperTest {

    @Autowired
    private ApplyInfoMapper applyInfoMapper;

    @Test
    public void testInsert() {
        ApplyInfo applyInfo = ApplyInfo.builder()
                .principalName("John Doe")
                .deposit(1000.0)
                .totalPrice(5000.0)
                .depositStatus(1)
                .cancelStatus(0)
                .payDeadline(new Date())
                .paymentSendDate(LocalDate.now())
                .balanceStatus(0)
                .updateTime(LocalDateTime.now())
                .depositRatio(0.2)
                .build();

        int result = applyInfoMapper.insert(applyInfo);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        ApplyInfo applyInfo = applyInfoMapper.selectById(90);
        Assertions.assertNotNull(applyInfo);
        System.out.println(applyInfo);
    }

    @Test
    public void testUpdate() {
        ApplyInfo applyInfo = applyInfoMapper.selectById(91);
        applyInfo.setPrincipalName("Updated Principal");
        int result = applyInfoMapper.updateById(applyInfo);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = applyInfoMapper.deleteById(93);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<ApplyInfo> applyInfos = applyInfoMapper.selectList(null);
        Assertions.assertNotNull(applyInfos);
        applyInfos.forEach(System.out::println);
    }
}
