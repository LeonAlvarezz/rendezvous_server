package com.example.rendezvous_server.model.brideEntity;

import com.example.rendezvous_server.model.Mode;
import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class ProjectTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_team_id;
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties("projectTeams")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("projectTeams")
    private User user;
    @Enumerated(EnumType.STRING)
    private Mode mode;


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
