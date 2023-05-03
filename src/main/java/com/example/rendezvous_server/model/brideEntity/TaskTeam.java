package com.example.rendezvous_server.model.brideEntity;

import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.Task;
import com.example.rendezvous_server.model.User;
import jakarta.persistence.*;
@Entity
public class TaskTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_team_id;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userTask;
}
