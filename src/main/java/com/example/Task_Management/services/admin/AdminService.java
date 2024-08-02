package com.example.Task_Management.services.admin;

import com.example.Task_Management.dto.CommentDTO;
import com.example.Task_Management.dto.ProjectDTO;
import com.example.Task_Management.dto.UserDto;

import java.util.List;

public interface AdminService {

    List<UserDto> getUsers();

    ProjectDTO createProject(ProjectDTO projectDTO);

    List<ProjectDTO> getAllProjects();

    void deleteProject(Long id);

    ProjectDTO getProjectById(Long id);

    ProjectDTO updateProject(Long id, ProjectDTO projectDTO);

    List<ProjectDTO> searchProjectByTitle(String title);

    CommentDTO createComment(Long projectId, String content);

    List<CommentDTO> getCommentsByProjectId(Long projectId);
}
