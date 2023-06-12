package ru.skypro.lessons.springboot.weblibraryhw.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibraryhw.exception.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.weblibraryhw.model.Employee;
import ru.skypro.lessons.springboot.weblibraryhw.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.weblibraryhw.repository.PagingAndSortingRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PagingAndSortingRepository pagingAndSortingRepository;

    public Collection<EmployeeFullInfo> getAllEmployees() {
        return employeeRepository.findAllEmployeeFullInfo();
    }

    @Override
    public Integer getSalarySum() {
        return getAllEmployees().stream()
                .mapToInt(employee -> IntStream.of(employee.getSalary()).sum())
                .sum();
    }

    @Override
    public EmployeeFullInfo getSalaryMin() {
        return getAllEmployees().stream()
                .min(Comparator.comparingInt(EmployeeFullInfo::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public EmployeeFullInfo getSalaryMax() {
        return getAllEmployees().stream()
                .max(Comparator.comparingInt(EmployeeFullInfo::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<EmployeeFullInfo> getSalaryAboveAverageEmployees() {
        double salaryAverage = getAllEmployees().stream()
                .mapToInt(EmployeeFullInfo::getSalary).average().getAsDouble();
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > salaryAverage)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<EmployeeFullInfo> getEmployeesByParamSalary(int paramSalary) {
        return getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > paramSalary)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeFullInfo getEmployeeByIdFullInfo(Integer id) {
        return employeeRepository.findByIdFullInfo(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<EmployeeFullInfo> getEmployeesByPosition(Integer position) {
        if (position != null) {
            return employeeRepository.findEmployeeByPosition(position);
        } else
            return getAllEmployees();
    }

    @Override
    public Collection<EmployeeFullInfo> getEmployeesWithHighestSalary() {
        return employeeRepository.findEmployeeWithHighestSalary();
    }

    @Override
    public Collection<EmployeeDTO> getEmployeeWithPage(Integer page) {
        Page<Employee> employeePage = pagingAndSortingRepository.findAll(PageRequest.of(page, 10));
        Collection<Employee> employeeList = employeePage.stream()
                .toList();
        return employeeList.stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeDTO.toEmployee());
    }

    @Override
    public void updateEmployeeById(Integer id, EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.save(employeeDTO.toEmployee());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        if (id > getAllEmployees().size() || id <= 0) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(id);
    }
}
