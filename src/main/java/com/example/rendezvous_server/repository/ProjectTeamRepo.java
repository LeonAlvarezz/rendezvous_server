package com.example.rendezvous_server.repository;

import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTeamRepo extends JpaRepository<ProjectTeam, Integer> {
//    @Query("SELECT p.project_name, p.description, p.mode, p.deadline, p.tag_id FROM project p JOIN project_team pt ON p.project_id = pt.project_id JOIN tag t ON p.tag_id = t.tag_id WHERE pt.user_id = :userId")
//@Query("SELECT new Project(p.project_id, p.project_name, p.description, p.project_deadline, p.tag) FROM Project p JOIN p.projectTeam pt JOIN pt.user u JOIN p.tag t WHERE u.userId = :userId")
}
