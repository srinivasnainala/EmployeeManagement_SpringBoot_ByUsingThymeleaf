package com.stu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stu.model.StudentLogin;
import com.stu.repository.StudentLoginRepo;


@Service
public class StudentLoginService {
@Autowired
StudentLoginRepo loginrepo;

public boolean Login(String username, String password) {
	StudentLogin user=loginrepo.findByusername(username);
	StudentLogin pass=loginrepo.findBypassword(password);
	if(loginrepo.findAll().contains(user)&&loginrepo.findAll().contains(pass))
	{
		return true;
	}
			return false;
}
}


