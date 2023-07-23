package constants;

import ru.skypro.lessons.springboot.weblibraryhw.dto.ReportDTO;
import ru.skypro.lessons.springboot.weblibraryhw.model.Report;

import java.util.List;

public class ReportConstants {

    public static final Report REPORT=new Report(
            1,
            "C:\\Users\\Пользователь\\IdeaProjects\\web-library-hw\\report.json");
    public static final List<ReportDTO> REPORT_DTO_LIST = List.of(
            new ReportDTO("1",1L,50000,100000,25000)
    );
}
