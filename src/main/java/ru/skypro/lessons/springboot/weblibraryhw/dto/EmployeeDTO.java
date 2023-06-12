package ru.skypro.lessons.springboot.weblibraryhw.dto;

import lombok.Getter;
import lombok.Setter;
import ru.skypro.lessons.springboot.weblibraryhw.model.Employee;
import ru.skypro.lessons.springboot.weblibraryhw.model.Position;

@Getter
@Setter
public class EmployeeDTO {
    private Integer id;
    private String name;
    private int salary;
    private Position position;

    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setPosition(employee.getPosition());
        return employeeDTO;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        employee.setPosition(this.getPosition());
        return employee;
    }
}
