package com.example.Task_Management.entities;

import com.example.Task_Management.dto.ProjectDTO;
import com.example.Task_Management.enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private String priority;

    private ProjectStatus projectStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public ProjectDTO getProjectDTO(){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(id);
        projectDTO.setTitle(title);
        projectDTO.setDescription(description);
        projectDTO.setEmployeeName(user.getName());
        projectDTO.setEmployeeId(user.getId());
        projectDTO.setProjectStatus(projectStatus);
        projectDTO.setDueDate(dueDate);
        projectDTO.setPriority(priority);
        return projectDTO;
    }



}
