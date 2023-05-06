package com.example.rendezvous_server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int tag_id;
    private String tag_name;
    @OneToMany(mappedBy = "tag")
    @JsonIgnoreProperties("tag")
    private Set<Project> projects;

    public Tag(int tag_id, String tag_name, Set<Project> projects) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
        this.projects = projects;
    }

    public Tag() {

    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tag_id=" + tag_id +
                ", tag_name='" + tag_name + '\'' +
                '}';
    }
}
