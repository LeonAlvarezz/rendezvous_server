package com.example.rendezvous_server.service;

import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.Task;
import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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


    public Project updateProject(int id, Project project) {
        Project updatedProject= projectRepo.findById(id).get();
        updatedProject.setProject_name(project.getProject_name());
        updatedProject.setDescription(project.getDescription());
        updatedProject.setProject_deadline(project.getProject_deadline());
        updatedProject.setTag(project.getTag());
        return projectRepo.save(updatedProject);
    }

    public Project getProjectById(int id) {
        return projectRepo.findById(id).get();
    }
    public void deleteProject(int id) {
        projectRepo.deleteById(id);
    }
//    public List<Project> getAllProjectById(@PathVariable int id)
//    {
//        List<Project> projectList = new ArrayList<>();
////        Streamable.of(projectRepo.getProjectByUserId(id)).forEach(projectList::add);
//        projectList = projectRepo.getProjectByUserId(id);
//        System.out.println(projectList);
//        return projectList;
//    }

    public List<Project> getProjectsByUserId(int user_id) {
        return projectRepo.findByAllProjectById(user_id);
    }


}
