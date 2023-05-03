package com.example.rendezvous_server.service;

import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.Task;
import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project saveProject(Project project)
    {
        return projectRepo.save(project);
    }

    public List<Project> getAllProject()
    {
        List<Project> projectList = new ArrayList<>();
        Streamable.of(projectRepo.findAll()).forEach(projectList::add);
        return projectList;
    }

    public Project getProjectById(int id) {
        Optional<Project> projectOptional = projectRepo.findById(id);
        if (projectOptional.isPresent()) {
            return projectOptional.get();
        } else {
            throw new RuntimeException("Project not found with id: " + id);
        }
    }

    public Project updateProject(int id, Project updatedProject)
    {
        Optional<Project> projectOptional = projectRepo.findById(id);
        if(projectOptional.isPresent())
        {
            Project project = projectOptional.get();
            project.setProject_name(updatedProject.getProject_name());
            project.setProject_deadline(updatedProject.getProject_deadline());
            project.setDescription(updatedProject.getDescription());
            project.setTag(updatedProject.getTag());
            return projectRepo.save(project);
        } else
        {
            throw new RuntimeException("Project not found");
        }
    }
}
