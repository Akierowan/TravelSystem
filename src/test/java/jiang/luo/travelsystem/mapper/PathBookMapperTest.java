package jiang.luo.travelsystem.mapper;

import jiang.luo.travelsystem.pojo.PathBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class PathBookMapperTest {

    @Autowired
    private PathBookMapper pathBookMapper;

    private PathBook testPathBook;

    @BeforeEach
    public void setUp() {
        testPathBook = new PathBook();
        testPathBook.setPathNumber("PN12345");
        testPathBook.setPath("Sample Path");
        testPathBook.setAdultPrice(300.0);
        testPathBook.setChildPrice(150.0);
        testPathBook.setDiscount("10%");
        testPathBook.setUpdateTime(LocalDateTime.now());
        testPathBook.setDeleteStatus(0);
        testPathBook.setLastVersionId(1);
    }

    @Test
    public void testInsert() {
        int result = pathBookMapper.insert(testPathBook);
        assertEquals(1, result);
    }

    @Test
    public void testSelectById() {
        pathBookMapper.insert(testPathBook);
        PathBook fetchedPathBook = pathBookMapper.selectById(testPathBook.getId());
        assertNotNull(fetchedPathBook);
        assertEquals("PN12345", fetchedPathBook.getPathNumber());
    }

    @Test
    public void testUpdate() {
        pathBookMapper.insert(testPathBook);
        testPathBook.setPath("Updated Path");
        pathBookMapper.updateById(testPathBook);
        PathBook updatedPathBook = pathBookMapper.selectById(testPathBook.getId());
        assertEquals("Updated Path", updatedPathBook.getPath());
    }

    @Test
    public void testDelete() {
        pathBookMapper.insert(testPathBook);
        int result = pathBookMapper.deleteById(testPathBook.getId());
        assertEquals(1, result);
        PathBook deletedPathBook = pathBookMapper.selectById(testPathBook.getId());
        assertNull(deletedPathBook);
    }
}
