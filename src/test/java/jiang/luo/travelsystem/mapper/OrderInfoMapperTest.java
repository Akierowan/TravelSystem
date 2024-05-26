package jiang.luo.travelsystem.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderInfoMapperTest {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Test
    public void testInsert() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setDeposit(1000.0);
        orderInfo.setApplyBookId(1);
        orderInfo.setTotalPrice(2000.0);
        orderInfo.setDepositStatus(1);
        orderInfo.setCancelStatus(0);
        orderInfo.setPayDeadline(new Date());
        orderInfo.setPaymentSendDate(new Date());
        orderInfo.setBalanceStatus(1);

        int result = orderInfoMapper.insert(orderInfo);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        OrderInfo orderInfo = orderInfoMapper.selectById(1);
        Assertions.assertNotNull(orderInfo);
        System.out.println(orderInfo);
    }

    @Test
    public void testUpdate() {
        OrderInfo orderInfo = orderInfoMapper.selectById(1);
        orderInfo.setDeposit(1500.0);
        int result = orderInfoMapper.updateById(orderInfo);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = orderInfoMapper.deleteById(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(null);
        Assertions.assertNotNull(orderInfos);
        orderInfos.forEach(System.out::println);
    }
}
