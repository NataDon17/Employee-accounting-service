package ru.skypro.lessons.springboot.weblibraryhw.service;

import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibraryhw.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Collection<EmployeeFullInfo> getAllEmployees();

    void createEmployee(EmployeeDTO employeeDTO);

    Employee getEmployeeById(Integer id);

    void updateEmployeeById(Integer id, EmployeeDTO employeeDTO);

    void deleteEmployeeById(Integer id);

    Integer getSalarySum();

    EmployeeFullInfo getSalaryMin();

    EmployeeFullInfo getSalaryMax();

    Collection<EmployeeFullInfo> getSalaryAboveAverageEmployees();

    Collection<EmployeeFullInfo> getEmployeesByParamSalary(int paramSalary);

    EmployeeFullInfo getEmployeeByIdFullInfo(Integer id);

    Collection<EmployeeFullInfo> getEmployeesByPosition(Integer position);

    Collection<EmployeeFullInfo> getEmployeesWithHighestSalary();

    Collection<EmployeeDTO> getEmployeeWithPage(Integer page);
}
