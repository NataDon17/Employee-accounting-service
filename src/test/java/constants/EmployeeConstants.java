package constants;


import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibraryhw.model.Employee;
import ru.skypro.lessons.springboot.weblibraryhw.model.Position;

import java.util.List;

public class EmployeeConstants {
    public static final Employee EMPLOYEE_1 = new Employee(1, "Sonya", 25000, new Position(1, "Тестировщик"));
    public static final Employee EMPLOYEE_2 = new Employee(2, "Alena", 35000, new Position(1, "Тестировщик"));
    public static final Employee EMPLOYEE_3 = new Employee(3, "Egor", 40000, new Position(2, "Разработчик"));
    public static final List<Employee> EMPLOYEE_LIST = List.of(
            EMPLOYEE_1,
            EMPLOYEE_2,
            EMPLOYEE_3
    );
    public static final EmployeeDTO EMPLOYEE_DTO_1 = new EmployeeDTO(1, "Sonya", 25000, new Position(1, "Тестировщик"));
    public static final EmployeeDTO EMPLOYEE_DTO_2 = new EmployeeDTO(2, "Alena", 35000, new Position(1, "Тестировщик"));
    public static final EmployeeDTO EMPLOYEE_DTO_3 = new EmployeeDTO(3, "Egor", 40000, new Position(2, "Разработчик"));
    public static final List<EmployeeDTO> EMPLOYEE_DTO_LIST = List.of(
            EMPLOYEE_DTO_1,
            EMPLOYEE_DTO_2,
            EMPLOYEE_DTO_3
    );
    public static final EmployeeFullInfo EMPLOYEE_FULL_INFO_1 = new EmployeeFullInfo("Sonya", 25000, "Тестировщик");
    public static final EmployeeFullInfo EMPLOYEE_FULL_INFO_2 = new EmployeeFullInfo("Alena", 35000, "Тестировщик");
    public static final EmployeeFullInfo EMPLOYEE_FULL_INFO_3 = new EmployeeFullInfo("Egor", 40000, "Разработчик");

    public static final List<EmployeeFullInfo> EMPLOYEE_FULL_INFO_LIST = List.of(
            EMPLOYEE_FULL_INFO_1,
            EMPLOYEE_FULL_INFO_2,
            EMPLOYEE_FULL_INFO_3
    );
}

