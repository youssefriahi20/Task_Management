package com.example.Task_Management.controllers.employee;

import com.example.Task_Management.dto.ProjectDTO;
import com.example.Task_Management.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> getProjectsByUserId() {
       return ResponseEntity.ok(employeeService.getProjectsByUserId());
    }
}
