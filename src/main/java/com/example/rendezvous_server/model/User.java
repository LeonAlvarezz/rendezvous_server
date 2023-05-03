package com.example.rendezvous_server.model;

import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import com.example.rendezvous_server.model.brideEntity.TaskTeam;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
    private String user_password;

    @OneToMany(mappedBy = "user")
    private Set<ProjectTeam> projectTeams = new HashSet<>();

    @OneToMany(mappedBy = "userTask")
    private Set<TaskTeam> taskTeams = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Mode mode;

    @OneToMany(mappedBy = "sender")
    private List<Comment> commentList;


}