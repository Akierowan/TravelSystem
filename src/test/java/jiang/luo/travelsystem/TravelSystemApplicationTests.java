package jiang.luo.travelsystem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.ApplyBook;
import jiang.luo.travelsystem.pojo.ApplyInfo;
import jiang.luo.travelsystem.pojo.PathBook;
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
    void testPay(){
        int id = 2;
        // 修改订单表中的订单支付状态
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setDepositStatus(1);
        applyInfo.setId(id);
        applyInfoMapper.updateById(applyInfo);
        System.out.println(applyInfo.getDeposit());
    }
    @Test
    void testPage(){
        int pageNum = 2;
        int pageSize = 0;
        Page<PathBook> page = new Page<>(pageNum, pageSize);
        Page<PathBook> pathBookPage = pathBookMapper.selectPage(page, null);
        System.out.println(pathBookPage.getRecords().size());
        System.out.println(pathBookPage.getTotal());
        System.out.println(pathBookPage.getRecords());

    }

    @Test
    void contextLoads() {
    }


    @Autowired
    ApplyBookMapper applyBookMapper;
    @Autowired
    ApplyInfoMapper applyInfoMapper;
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
        ApplyInfo applyInfo = new ApplyInfo();

        Map<String,Object> mp = new HashMap<>();
        mp.put("apply_book_id",12);

        List<ApplyInfo> applyInfos = applyInfoMapper.selectByMap(mp);

        applyInfos.forEach(System.out::println);

    }

    @Test
        //测试orderinfo
    void test3(){
        ApplyInfo applyInfo = new ApplyInfo();


        applyInfo.setId(0);
        applyInfo.setDeposit(11.11);
        applyInfo.setApplyBookId(12);
        applyInfo.setTotalPrice(111.11);
        applyInfo.setDepositStatus(0);
        applyInfo.setCancelStatus(0);

        int i = applyInfoMapper.insert(applyInfo);

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
