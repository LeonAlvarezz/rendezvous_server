package com.example.rendezvous_server.model;

import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import com.example.rendezvous_server.model.brideEntity.TaskTeam;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String email;
    private String user_name;
    private String user_password;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<ProjectTeam> projectTeams;

    @OneToMany(mappedBy = "userTask")
    private List<TaskTeam> taskTeams = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Mode mode;

    @OneToMany(mappedBy = "sender")
    private List<Comment> commentList;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", mode=" + mode +
                '}';
    }
}