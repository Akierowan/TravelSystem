package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.ApplyBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ApplyBookMapperTest {

    @Autowired
    private ApplyBookMapper applyBookMapper;

    private ApplyBook testApplyBook;

    @BeforeEach
    public void setUp() {
        testApplyBook = new ApplyBook();
        testApplyBook.setTourCode("TC123");
        testApplyBook.setDepartDate(LocalDate.now());
        testApplyBook.setName("John Doe");
        testApplyBook.setGender(1);
        testApplyBook.setBirthday(LocalDate.of(1990, 1, 1));
        testApplyBook.setPhone("1234567890");
        testApplyBook.setAddress("123 Main St");
        testApplyBook.setEmail("john.doe@example.com");
        testApplyBook.setPostalCode("12345");
        testApplyBook.setNameVice("Jane Doe");
        testApplyBook.setRelationship("Spouse");
        testApplyBook.setAddressVice("123 Main St");
        testApplyBook.setPhoneVice("0987654321");
        testApplyBook.setUpdateTime(LocalDate.now().atStartOfDay());
        testApplyBook.setApplyInfoId(1);
        testApplyBook.setPathNumber("PN123");
    }

    @Test
    public void testInsert() {
        int result = applyBookMapper.insert(testApplyBook);
        assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        applyBookMapper.insert(testApplyBook);
        ApplyBook fetchedApplyBook = applyBookMapper.selectById(testApplyBook.getId());
        assertNotNull(fetchedApplyBook);
        assertEquals("John Doe", fetchedApplyBook.getName());
    }

    @Test
    public void testUpdate() {
        applyBookMapper.insert(testApplyBook);
        testApplyBook.setName("John Updated");
        applyBookMapper.updateById(testApplyBook);
        ApplyBook updatedApplyBook = applyBookMapper.selectById(testApplyBook.getId());
        assertEquals("John Updated", updatedApplyBook.getName());
    }

    @Test
    public void testDelete() {
        applyBookMapper.insert(testApplyBook);
        int result = applyBookMapper.deleteById(testApplyBook.getId());
        assertEquals(1, result);
        ApplyBook deletedApplyBook = applyBookMapper.selectById(testApplyBook.getId());
        assertNull(deletedApplyBook);
    }
}
