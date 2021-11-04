package com.igorkunicyn.student.repositories;

import com.igorkunicyn.student.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();
    User findByUsername(String username);
    User findById(Long id);

}
