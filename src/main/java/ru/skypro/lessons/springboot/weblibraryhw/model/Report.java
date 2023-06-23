package ru.skypro.lessons.springboot.weblibraryhw.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "report")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "file", columnDefinition = "text")
    private String file;

    @Override
    public String toString() {
        return "Отчет: " +
                "номер отчета: " + id +
                ", содержание: " + file + '\n';
    }
}
