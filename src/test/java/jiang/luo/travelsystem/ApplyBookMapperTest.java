package jiang.luo.travelsystem;

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
}
