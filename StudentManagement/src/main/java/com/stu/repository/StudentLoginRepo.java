package com.stu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stu.model.StudentLogin;
@Repository
public interface StudentLoginRepo extends JpaRepository<StudentLogin, Integer>{
	StudentLogin findByusername(String username);
	StudentLogin findBypassword(String password);
}
