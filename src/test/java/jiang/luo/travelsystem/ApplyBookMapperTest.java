package jiang.luo.travelsystem;
import java.util.Date;
import java.time.LocalDate;

import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.pojo.ApplyBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplyBookMapperTest {
    @Autowired
    ApplyBookMapper applyBookMapper;
    @Test
    void test1(){
        List<ApplyBook> applyBookList = applyBookMapper.selectList(null);
        applyBookList.forEach(System.out::println);

    }


    @Test
    void test2(){
        ApplyBook applyBook = new ApplyBook();

        applyBook.setId(0);
        applyBook.setTourCode("123");
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

//        ApplyBook applyBook1 = new ApplyBook();




        int i = applyBookMapper.insert(applyBook);
//        int q = applyBookMapper.insert(applyBook1);

        System.out.println("插入" + i +  "条信息到数据库");




    }
}
