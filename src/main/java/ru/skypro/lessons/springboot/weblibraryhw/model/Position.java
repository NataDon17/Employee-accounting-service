package ru.skypro.lessons.springboot.weblibraryhw.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
