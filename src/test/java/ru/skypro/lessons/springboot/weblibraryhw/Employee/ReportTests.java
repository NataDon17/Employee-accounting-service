package ru.skypro.lessons.springboot.weblibraryhw.Employee;

import static constants.ReportConstants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import ru.skypro.lessons.springboot.weblibraryhw.repository.ReportRepository;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ReportTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void cleanEmployeeTable() {
        reportRepository.deleteAll();
    }

    @Test
    public void createReport_whenIdReturn_NewReportId() throws Exception {
        String report = objectMapper.writeValueAsString(REPORT_DTO);

        mockMvc.perform(post("/report/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(report))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber());
    }

    @Test
    public void givenReportById_whenIsId_ReturnReport() throws Exception {
        String report = objectMapper.writeValueAsString(REPORT);

        mockMvc.perform(post("/report/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(report))
                .andExpect(status().isOk());
        mockMvc.perform(get("/report/{id}", 1))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void givenNoReportInDatabase_whenGetOnReportList_thenNotFound() throws Exception {
        String report = objectMapper.writeValueAsString(REPORT);

        mockMvc.perform(post("/report/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(report))
                .andExpect(status().isOk());
        mockMvc.perform(get("/report/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
