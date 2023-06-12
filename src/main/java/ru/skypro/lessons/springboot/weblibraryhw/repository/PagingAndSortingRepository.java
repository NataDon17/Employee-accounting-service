package ru.skypro.lessons.springboot.weblibraryhw.repository;

import ru.skypro.lessons.springboot.weblibraryhw.model.Employee;

public interface PagingAndSortingRepository extends org.springframework.data.repository.PagingAndSortingRepository<Employee, Integer> {
}
