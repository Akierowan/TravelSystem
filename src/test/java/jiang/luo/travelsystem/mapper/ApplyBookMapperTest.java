package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.ApplyBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ApplyBookMapperTest {

    @Autowired
    private ApplyBookMapper applyBookMapper;

    @Test
    public void testInsert() {
        ApplyBook applyBook = new ApplyBook();
        applyBook.setTourCode("T123");
        applyBook.setDepartDate(LocalDate.of(2024, 6, 1));
        applyBook.setPathNumber("P123");
        applyBook.setName("John Doe");
        applyBook.setGender(1);
        applyBook.setBirthday(LocalDate.of(1990, 1, 1));
        applyBook.setPhone("1234567890");
        applyBook.setAddress("123 Street, City, Country");
        applyBook.setEmail("john@example.com");
        applyBook.setPostalCode("12345");
        applyBook.setNameVice("Jane Doe");
        applyBook.setRelationship("Spouse");
        applyBook.setAddressVice("123 Street, City, Country");
        applyBook.setPhoneVice("0987654321");
        applyBook.setUpdateTime(LocalDateTime.now());
        applyBook.setApplyInfoId(1);

        int result = applyBookMapper.insert(applyBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        ApplyBook applyBook = applyBookMapper.selectById(4);
        Assertions.assertNotNull(applyBook);
        System.out.println(applyBook);
    }

    @Test
    public void testUpdate() {
        ApplyBook applyBook = applyBookMapper.selectById(5);
        applyBook.setName("Updated Name");
        int result = applyBookMapper.updateById(applyBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = applyBookMapper.deleteById(7);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<ApplyBook> applyBooks = applyBookMapper.selectList(null);
        Assertions.assertNotNull(applyBooks);
        applyBooks.forEach(System.out::println);
    }
}
