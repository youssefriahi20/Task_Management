package com.example.Task_Management.dto;

import com.example.Task_Management.enums.ProjectStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {
    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private String priority;

    private ProjectStatus projectStatus;

    private Long employeeId;

    private String employeeName;

}
