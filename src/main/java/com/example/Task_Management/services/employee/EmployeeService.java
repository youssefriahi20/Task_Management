package com.example.Task_Management.services.employee;

import com.example.Task_Management.dto.ProjectDTO;

import java.util.List;

public interface EmployeeService {
     List<ProjectDTO>getProjectsByUserId();
}
