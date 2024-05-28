package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.PathBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class PathBookMapperTest {

    @Autowired
    private PathBookMapper pathBookMapper;

    @Test
    public void testInsert() {
        PathBook pathBook = new PathBook();
        pathBook.setPathNumber("12345");
        pathBook.setPath("Sample Path");
        pathBook.setAdultPrice(100.0);
        pathBook.setChildPrice(50.0);
        pathBook.setDiscount("10% off");
        pathBook.setUpdateTime(LocalDateTime.now());
        pathBook.setDeleteStatus(0);
        pathBook.setLastVersionId(0);

        int result = pathBookMapper.insert(pathBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        PathBook pathBook = pathBookMapper.selectById(12);
        Assertions.assertNotNull(pathBook);
        System.out.println(pathBook);
    }

    @Test
    public void testUpdate() {
        PathBook pathBook = pathBookMapper.selectById(13);
        pathBook.setPath("Updated Path");
        int result = pathBookMapper.updateById(pathBook);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        int result = pathBookMapper.deleteById(15);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testSelectAll() {
        List<PathBook> pathBooks = pathBookMapper.selectList(null);
        Assertions.assertNotNull(pathBooks);
        pathBooks.forEach(System.out::println);
    }
}
