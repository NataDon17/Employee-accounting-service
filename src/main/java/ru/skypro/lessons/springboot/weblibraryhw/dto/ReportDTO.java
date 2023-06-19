package ru.skypro.lessons.springboot.weblibraryhw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ReportDTO implements Serializable {
    private String positionName;
    private long count;
    private int minSalary;
    private int maxSalary;
    private double avgSalary;

    @Override
    public String toString() {
        return "Отчет по отделам \n" +
                "Название отдела " + positionName + '\n' +
                "Количество сотрудников " + count + '\n' +
                "Минимальная зарплата по отделу " + minSalary + '\n' +
                "Максимальная зарплата по отделу " + maxSalary + '\n' +
                "Средняя зарплата " + avgSalary + '\n';
    }
}
