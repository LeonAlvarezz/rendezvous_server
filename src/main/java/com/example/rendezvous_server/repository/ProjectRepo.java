package com.example.rendezvous_server.repository;

import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
//    List<Project> findByProjectTeamsUserUserId(int user_id);
    @Query("SELECT p FROM Project p JOIN p.projectTeams pt JOIN pt.user u WHERE u.user_id = :userId")
    List<Project> findByAllProjectById(@Param("userId") int userId);

}
