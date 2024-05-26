package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.ApplyBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class ApplyBookMapperTest {

    @Autowired
    private ApplyBookMapper applyBookMapper;

    @Test
    public void testInsert() {
        ApplyBook applyBook = new ApplyBook();
        applyBook.setTourCode("ABC123");
        applyBook.setDepartDate(new Date());
        applyBook.setName("John Doe");
        applyBook.setGender(1);
        applyBook.setBirthday(new Date());
        applyBook.setPhone("1234567890");
        applyBook.setAddress("123 Main Street");
        applyBook.setEmail("john@example.com");
        applyBook.setPostalCode("12345");
        applyBook.setNameVice("Jane Doe");
        applyBook.setRelationship("Spouse");
        applyBook.setAddressVice("456 Broad Street");
        applyBook.setPhoneVice("0987654321");
        applyBook.setUpdateTime(new Date());

        int result = applyBookMapper.insert(applyBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        ApplyBook applyBook = applyBookMapper.selectById(5);
        Assertions.assertNotNull(applyBook);
        System.out.println(applyBook);
    }

    @Test
    public void testUpdate() {
        ApplyBook applyBook = applyBookMapper.selectById(4);
        applyBook.setName("Jane Smith");
        int result = applyBookMapper.updateById(applyBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = applyBookMapper.deleteById(3);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<ApplyBook> applyBooks = applyBookMapper.selectList(null);
        Assertions.assertNotNull(applyBooks);
        applyBooks.forEach(System.out::println);
    }
}