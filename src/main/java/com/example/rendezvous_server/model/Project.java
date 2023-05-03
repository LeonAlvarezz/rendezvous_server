package com.example.rendezvous_server.model;

import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int project_id;
    private String project_name;
    @Temporal(TemporalType.DATE)
    private Date project_deadline;
    private String description;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
    @OneToMany(mappedBy = "task_id")
    private List<Task> tasks;

    @OneToMany(mappedBy = "project")
    private Set<ProjectTeam> projectTeams = new HashSet<>();

    public Project(int project_id, String project_name, Date project_deadline, String description, Tag tag) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_deadline = project_deadline;
        this.description = description;
        this.tag = tag;
    }

    public Project() {

    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Date getProject_deadline() {
        return project_deadline;
    }

    public void setProject_deadline(Date project_deadline) {
        this.project_deadline = project_deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
