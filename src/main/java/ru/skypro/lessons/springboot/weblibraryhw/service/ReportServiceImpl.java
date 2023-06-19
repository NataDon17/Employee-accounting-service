package ru.skypro.lessons.springboot.weblibraryhw.service;

import org.springframework.core.io.Resource;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibraryhw.model.Report;
import ru.skypro.lessons.springboot.weblibraryhw.repository.ReportRepository;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public Integer createReport() throws IOException {
        Report report = new Report();
        report.setFile(String.valueOf((reportRepository.createReport())));
        reportRepository.save(report);
        return report.getId();
    }

    @Override
    public ResponseEntity<Resource> getReportById(Integer id) throws IOException {
        String file = "report.json";
        String json = String.valueOf(reportRepository.findById(id));
        Resource resource = new ByteArrayResource(json.getBytes());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}
