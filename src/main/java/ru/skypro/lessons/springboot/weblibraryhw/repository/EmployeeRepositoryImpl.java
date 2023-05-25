package ru.skypro.lessons.springboot.weblibraryhw.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibraryhw.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90000),
            new Employee("Дима", 102000),
            new Employee("Олег", 80000),
            new Employee("Вика", 165000));

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeList);
    }
}
