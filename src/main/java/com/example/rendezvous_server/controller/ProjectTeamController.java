package com.example.rendezvous_server.controller;

import com.example.rendezvous_server.model.Mode;
import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import com.example.rendezvous_server.service.ProjectTeamService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectTeamController {
    @Autowired
    ProjectTeamService projectTeamService;

    @PostMapping("project/team/save")
    public ResponseEntity<ProjectTeam> saveProjectTeam(@RequestBody ProjectTeam projectTeam)
    {
        projectTeamService.saveProjectTeam(projectTeam);
        return new ResponseEntity<>(projectTeam, HttpStatus.OK);
    }



}
