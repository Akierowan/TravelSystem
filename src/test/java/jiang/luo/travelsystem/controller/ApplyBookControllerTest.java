package jiang.luo.travelsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.ApplyBookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApplyBookController.class)
public class ApplyBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ApplyBookService applyBookService;

    @InjectMocks
    private ApplyBookController applyBookController;

    @Test
    public void testSaveApplyBook() throws Exception {
        ApplyBookDTO applyBookDTO = new ApplyBookDTO();
        applyBookDTO.setName("Test");

        doNothing().when(applyBookService).saveApplyBook(any(ApplyBookDTO.class));

        mockMvc.perform(post("/applybook/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(applyBookDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true));

        verify(applyBookService, times(1)).saveApplyBook(any(ApplyBookDTO.class));
    }

    @Test
    public void testPage() throws Exception {
        PageQueryDTO pageQueryDTO = new PageQueryDTO();
        pageQueryDTO.setPageNum(1);
        pageQueryDTO.setPageSize(10);

        PageResult pageResult = new PageResult(1, Collections.singletonList(new ApplyBook()));

        when(applyBookService.pageQuery(any(PageQueryDTO.class))).thenReturn(pageResult);

        mockMvc.perform(post("/applybook/page")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(pageQueryDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.total").value(1))
                .andExpect(jsonPath("$.data.records.length()").value(1));

        verify(applyBookService, times(1)).pageQuery(any(PageQueryDTO.class));
    }

    @Test
    public void testGetById() throws Exception {
        ApplyBook applyBook = new ApplyBook();
        applyBook.setId(1);
        applyBook.setName("Test");

        when(applyBookService.getById(1)).thenReturn(applyBook);

        mockMvc.perform(get("/applybook?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1))
                .andExpect(jsonPath("$.data.name").value("Test"));

        verify(applyBookService, times(1)).getById(1);
    }

    @Test
    public void testAlterApplyBook() throws Exception {
        ApplyBookDTO applyBookDTO = new ApplyBookDTO();
        applyBookDTO.setId(1);
        applyBookDTO.setName("Updated Test");

        doNothing().when(applyBookService).updateApplyBook(any(ApplyBookDTO.class));

        mockMvc.perform(post("/applybook/alter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(applyBookDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true));

        verify(applyBookService, times(1)).updateApplyBook(any(ApplyBookDTO.class));
    }

    @Test
    public void testCancelParticipation() throws Exception {
        doNothing().when(applyBookService).cancelParticipation(1);

        mockMvc.perform(put("/applybook/cancel?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success").value(true));

        verify(applyBookService, times(1)).cancelParticipation(1);
    }
}
