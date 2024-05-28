package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.pojo.PathBookDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.service.impl.PathBookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PathBookServiceTest {

    @Mock
    private PathBookMapper pathBookMapper;

    @InjectMocks
    private PathBookServiceImpl pathBookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePathBook_NewPath() throws Exception {
        PathBookDTO pathBookDTO = new PathBookDTO();
        pathBookDTO.setPathNumber("12345");

        PathBook pathBook = new PathBook();
        BeanUtils.copyProperties(pathBookDTO, pathBook);

        pathBookService.savePathBook(pathBookDTO);

        verify(pathBookMapper, times(1)).insert(any(PathBook.class));
    }

    @Test
    public void testSavePathBook_UpdatePath() throws Exception {
        PathBookDTO pathBookDTO = new PathBookDTO();
        pathBookDTO.setId(1);
        pathBookDTO.setPathNumber("12345");

        PathBook oldPathBook = new PathBook();
        oldPathBook.setId(1);
        oldPathBook.setDeleteStatus(0);

        when(pathBookMapper.selectById(1)).thenReturn(oldPathBook);

        pathBookService.savePathBook(pathBookDTO);

        verify(pathBookMapper, times(1)).updateById(any(PathBook.class));
        verify(pathBookMapper, times(1)).insert(any(PathBook.class));
    }

    @Test
    public void testSavePathBook_UpdatePath_ThrowsException() {
        PathBookDTO pathBookDTO = new PathBookDTO();
        pathBookDTO.setId(1);
        pathBookDTO.setPathNumber("12345");

        PathBook oldPathBook = new PathBook();
        oldPathBook.setId(1);
        oldPathBook.setDeleteStatus(1);

        when(pathBookMapper.selectById(1)).thenReturn(oldPathBook);

        Exception exception = assertThrows(Exception.class, () -> {
            pathBookService.savePathBook(pathBookDTO);
        });

        assertNotNull(exception);
    }

    @Test
    public void testPageQuery() {
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);
        pageQueryDTO.setParam("12345");

        Page<PathBook> page = new Page<>(1, 10);
        PathBook pathBook = new PathBook();
        pathBook.setPathNumber("12345");
        page.setRecords(Collections.singletonList(pathBook));
        page.setTotal(1);

        when(pathBookMapper.selectPage(any(Page.class), any(QueryWrapper.class))).thenReturn(page);

        PageResult result = pathBookService.pageQuery(pageQueryDTO);

        assertEquals(1, result.getTotal());
        assertEquals(1, result.getRecords().size());
        assertEquals(pathBook, result.getRecords().get(0));

        verify(pathBookMapper, times(1)).selectPage(any(Page.class), any(QueryWrapper.class));
    }
}
