package com.example.rendezvous_server.model;

import com.example.rendezvous_server.model.brideEntity.TaskTeam;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;
    private String task_name;
    private String task_status;
    @Temporal(TemporalType.DATE)
    private Date task_deadline;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "task")
    private Set<TaskTeam> taskTeam = new HashSet<>();

    @OneToMany(mappedBy = "taskComment")
    private List<Comment> commentList;

    public Task(int task_id, String task_name, String task_status, Date task_deadline, Set<TaskTeam> taskTeam) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_status = task_status;
        this.task_deadline = task_deadline;
        this.taskTeam = taskTeam;
    }

    public Task() {

    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public Date getTask_deadline() {
        return task_deadline;
    }

    public void setTask_deadline(Date task_deadline) {
        this.task_deadline = task_deadline;
    }

    public Set<TaskTeam> getTaskTeam() {
        return taskTeam;
    }

    public void setTaskTeam(Set<TaskTeam> taskTeam) {
        this.taskTeam = taskTeam;
    }
}
