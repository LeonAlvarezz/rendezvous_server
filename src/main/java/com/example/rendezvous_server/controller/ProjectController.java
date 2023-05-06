package com.example.rendezvous_server.controller;

import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.service.ProjectService;
import com.example.rendezvous_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("project/get")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @PostMapping("project/save")
    public ResponseEntity<Project> saveProject(@RequestBody Project project)
    {
        projectService.saveProject(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project project)
    {
        projectService.updateProject(id, project);
        return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
    }

    @DeleteMapping("project/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id)
    {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("project/get/{user_id}")
    public ResponseEntity<List<Project>> getAllProjectById(@PathVariable int user_id)
    {
        List<Project> projectList = projectService.getProjectsByUserId(user_id);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }
}
