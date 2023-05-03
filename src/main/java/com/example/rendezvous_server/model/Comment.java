package com.example.rendezvous_server.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comment_id;
    private String comment_content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date comment_date;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task taskComment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User sender;



}
