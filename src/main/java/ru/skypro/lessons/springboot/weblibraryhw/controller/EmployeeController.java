package ru.skypro.lessons.springboot.weblibraryhw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibraryhw.model.Employee;
import ru.skypro.lessons.springboot.weblibraryhw.service.EmployeeService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public Collection<EmployeeFullInfo> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salary/sum")
    public Integer getSalarySum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/salary/min")
    public EmployeeFullInfo getSalaryMin() {
        return employeeService.getSalaryMin();
    }

    @GetMapping("/salary/max")
    public EmployeeFullInfo getSalaryMax() {
        return employeeService.getSalaryMax();
    }

    @GetMapping("/high-salary")
    public Collection<EmployeeFullInfo> getSalaryAboveAverageEmployees() {
        return employeeService.getSalaryAboveAverageEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/salaryHigherThan")
    public Collection<EmployeeFullInfo> getEmployeesByParamSalary(@RequestParam("paramSalary") int paramSalary) {
        return employeeService.getEmployeesByParamSalary(paramSalary);
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeFullInfo getEmployeeByIdFullInfo(@PathVariable Integer id) {
        return employeeService.getEmployeeByIdFullInfo(id);
    }

    @GetMapping("/position")
    public Collection<EmployeeFullInfo> getEmployeesByPosition(@RequestParam Optional<Integer> position) {
        return employeeService.getEmployeesByPosition(position.orElse(null));
    }

    @GetMapping("/withHighestSalary")
    public Collection<EmployeeFullInfo> getEmployeesWithHighestSalary() {
        return employeeService.getEmployeesWithHighestSalary();
    }

    @GetMapping("/page")
    public Collection<EmployeeDTO> getEmployeeWithPage(@RequestParam("page") Integer page) {
        return employeeService.getEmployeeWithPage(page);
    }
}
