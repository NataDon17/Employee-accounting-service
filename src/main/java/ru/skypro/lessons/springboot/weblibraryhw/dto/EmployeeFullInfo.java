package ru.skypro.lessons.springboot.weblibraryhw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeFullInfo {
    private String name;
    private int salary;
    private String positionName;
}
