package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.FinanceBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class FinanceBookMapperTest {

    @Autowired
    private FinanceBookMapper financeBookMapper;

    @Test
    public void testInsert() {
        FinanceBook financeBook = new FinanceBook();
        financeBook.setAmount(1000.0);
        financeBook.setType(0);
        financeBook.setUpdateTime(new Date());
        financeBook.setOrderInfoId(1);

        int result = financeBookMapper.insert(financeBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        FinanceBook financeBook = financeBookMapper.selectById(1);
        Assertions.assertNotNull(financeBook);
        System.out.println(financeBook);
    }

    @Test
    public void testUpdate() {
        FinanceBook financeBook = financeBookMapper.selectById(1);
        financeBook.setAmount(1500.0);
        int result = financeBookMapper.updateById(financeBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = financeBookMapper.deleteById(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<FinanceBook> financeBooks = financeBookMapper.selectList(null);
        Assertions.assertNotNull(financeBooks);
        financeBooks.forEach(System.out::println);
    }
}
