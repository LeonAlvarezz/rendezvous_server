package com.example.rendezvous_server.model.brideEntity;

import com.example.rendezvous_server.model.Mode;
import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.User;
import jakarta.persistence.*;

@Entity
public class ProjectTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_team_id;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    private Mode mode;


}
