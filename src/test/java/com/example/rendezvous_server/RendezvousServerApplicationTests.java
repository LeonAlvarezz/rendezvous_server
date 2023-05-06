package com.example.rendezvous_server;

import com.example.rendezvous_server.model.Mode;
import com.example.rendezvous_server.model.Project;
import com.example.rendezvous_server.model.User;
import com.example.rendezvous_server.model.brideEntity.ProjectTeam;
import com.example.rendezvous_server.repository.ProjectTeamRepo;
import com.example.rendezvous_server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RendezvousServerApplicationTests {
	@Autowired
	UserService userService;
	@Test
	void contextLoads() {
//		String email = "ponleu@gmail.com";
//		String password = "ponleu";
//		userService.validateLogin(email, password);
		Project project;
		ProjectTeam projectTeam;
//		project.setProjectTeams(projectTeam.getUser().getUser_id());
	}

}
