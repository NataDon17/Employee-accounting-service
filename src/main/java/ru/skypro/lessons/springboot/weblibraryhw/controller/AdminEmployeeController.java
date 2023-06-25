package ru.skypro.lessons.springboot.weblibraryhw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibraryhw.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibraryhw.service.EmployeeService;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/admin/employees")
@RequiredArgsConstructor
public class AdminEmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public Collection<EmployeeFullInfo> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
    }

    @DeleteMapping("/del/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public void updateEmployeeById(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployeeById(id, employeeDTO);
    }

    @PostMapping(value = "/employees/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createEmployeeFromFile(@RequestParam("file") MultipartFile file) throws IOException {
        employeeService.createEmployeeFromFile(file);
    }
}
