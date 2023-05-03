package com.example.rendezvous_server.repository;

import com.example.rendezvous_server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT email FROM user WHERE email = :email ", nativeQuery = true)
    List<String> checkUserEmail(@Param("email") String email);
    @Query(value = "SELECT user_password FROM user WHERE user_password = :password LIMIT 1", nativeQuery = true)
    String checkUserPassword(@Param("password") String password);
    @Query(value = "SELECT * FROM user WHERE email = :email ", nativeQuery = true)
    User getUserInfoByEmail(@Param("email")String email);

}
