package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.FinanceBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class FinanceBookMapperTest {

    @Autowired
    private FinanceBookMapper financeBookMapper;

    private FinanceBook testFinanceBook;

    @BeforeEach
    public void setUp() {
        testFinanceBook = new FinanceBook();
        testFinanceBook.setAmount(500.0);
        testFinanceBook.setType(1);
        testFinanceBook.setUpdateTime(LocalDateTime.now());
        testFinanceBook.setApplyInfoId(1);
    }

    @Test
    public void testInsert() {
        int result = financeBookMapper.insert(testFinanceBook);
        assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        financeBookMapper.insert(testFinanceBook);
        FinanceBook fetchedFinanceBook = financeBookMapper.selectById(testFinanceBook.getId());
        assertNotNull(fetchedFinanceBook);
        assertEquals(500.0f, fetchedFinanceBook.getAmount());
    }

    @Test
    public void testUpdate() {
        financeBookMapper.insert(testFinanceBook);
        testFinanceBook.setAmount(600.0);
        financeBookMapper.updateById(testFinanceBook);
        FinanceBook updatedFinanceBook = financeBookMapper.selectById(testFinanceBook.getId());
        assertEquals(600.0f, updatedFinanceBook.getAmount());
    }

    @Test
    public void testDelete() {
        financeBookMapper.insert(testFinanceBook);
        int result = financeBookMapper.deleteById(testFinanceBook.getId());
        assertEquals(1, result);
        FinanceBook deletedFinanceBook = financeBookMapper.selectById(testFinanceBook.getId());
        assertNull(deletedFinanceBook);
    }
}
