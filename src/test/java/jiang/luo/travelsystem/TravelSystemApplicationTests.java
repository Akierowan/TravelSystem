package jiang.luo.travelsystem;

import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.mapper.OrderInfoMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.ApplyBook;
import jiang.luo.travelsystem.pojo.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TravelSystemApplicationTests {

    @Test
    void contextLoads() {
    }




    @Autowired
    ApplyBookMapper applyBookMapper;
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    PathBookMapper pathBookMapper;


/*
    @Test
    void test1(){
        List<ApplyBook> applyBookList = applyBookMapper.selectList(null);
        applyBookList.forEach(System.out::println);

    }
*/

    @Test
    void test_insert(){
        OrderInfo orderInfo = new OrderInfo();

        Map<String,Object> mp = new HashMap<>();
        mp.put("apply_book_id",12);

        List<OrderInfo> orderInfos = orderInfoMapper.selectByMap(mp);

        orderInfos.forEach(System.out::println);

    }

    @Test
        //测试orderinfo
    void test3(){
        OrderInfo orderInfo = new OrderInfo();


        orderInfo.setId(0);
        orderInfo.setDeposit(11.11);
        orderInfo.setApplyBookId(12);
        orderInfo.setTotalPrice(111.11);
        orderInfo.setDepositStatus(0);
        orderInfo.setCancelStatus(0);

        int i = orderInfoMapper.insert(orderInfo);

        System.out.println("成功插入" + i + "条记录");
    }


    @Test
        //测试applybook
    void test2(){
        ApplyBook applyBook = new ApplyBook();

        applyBook.setId(0);
        applyBook.setTourCode("1213");
        applyBook.setDepartDate(new Date());
        applyBook.setName("123");
        applyBook.setGender(0);
        applyBook.setBirthday(new Date());
        applyBook.setPhone("123");
        applyBook.setAddress("123");
        applyBook.setEmail("123");
        applyBook.setPostalCode("123");
        applyBook.setNameVice("123");
        applyBook.setRelationship("123");
        applyBook.setAddressVice("123");
        applyBook.setPhoneVice("123");
        applyBook.setUpdateTime(new Date());

        int i = applyBookMapper.insert(applyBook);

        System.out.println("插入" + i +  "条信息到数据库");

    }

}
