package com.example.rendezvous_server.model;

import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int project_id;
    private String project_name;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMMM d, yyyy hh:mm:ss")
    private Date project_deadline;
    private String description;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @OneToMany(mappedBy = "task_id")
    private List<Task> tasks;

    @OneToMany(mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<ProjectTeam> projectTeams = new ArrayList<>();

    public Project(int project_id, String project_name, Date project_deadline, String description, Tag tag) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_deadline = project_deadline;
        this.description = description;
        this.tag = tag;
    }

    public Project() {

    }

    public List<ProjectTeam> getProjectTeams() {
        return projectTeams;
    }

    public void setProjectTeams(List<ProjectTeam> projectTeams) {
        this.projectTeams = projectTeams;
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

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", project_deadline=" + project_deadline +
                ", description='" + description + '\'' +
                '}';
    }
}
