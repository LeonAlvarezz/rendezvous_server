package com.example.rendezvous_server.service;

import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import com.example.rendezvous_server.repository.ProjectTeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectTeamService {
    @Autowired
    private ProjectTeamRepo projectTeamRepo;

    public ProjectTeam saveProjectTeam(ProjectTeam projectTeam)
    {
        return projectTeamRepo.save(projectTeam);
    }


}
