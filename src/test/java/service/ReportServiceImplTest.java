package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import ru.skypro.lessons.springboot.weblibraryhw.dto.ReportDTO;
import ru.skypro.lessons.springboot.weblibraryhw.model.Report;
import ru.skypro.lessons.springboot.weblibraryhw.repository.ReportRepository;
import ru.skypro.lessons.springboot.weblibraryhw.service.ReportServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static constants.ReportConstants.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReportServiceImplTest {
    @Mock
    private ReportRepository reportRepositoryMock;
    @InjectMocks
    private ReportServiceImpl out;

    @Test
    public void createReportIdReturnNewReport() throws IOException {
//        String fileName = "report.json";
//        String json = String.valueOf(REPORT_DTO_LIST);
//        Path path = Paths.get(fileName);
//        try {
//            Files.writeString(path, json);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        Report report = new Report();
//        report.setFilePath(String.valueOf(path.toAbsolutePath()));
//        when(reportRepositoryMock.save(report)).thenReturn(report);
//        report.setId(1);
//        out.createReport();
    }

    @Test
    public void getReportByIdIsIdReturnReport() throws IOException {
        when(reportRepositoryMock.findById(any()))
                .thenReturn(Optional.of(REPORT));
        String path = Optional.of(REPORT)
                .map(ReportDTO::fromReport)
                .orElseThrow(IOException::new)
                .getFilePath();
        MockMultipartFile newFile = new MockMultipartFile(
                "report",
                "report.json",
                MediaType.APPLICATION_JSON_VALUE,
                path.getBytes());

        out.getReportById(1);

    }
}
