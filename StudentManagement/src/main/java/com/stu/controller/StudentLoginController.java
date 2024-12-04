package com.stu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stu.service.StudentLoginService;



@Controller
public class StudentLoginController {
@Autowired
StudentLoginService loginservice;
@GetMapping("/login")
public String login()
{
	return "login";
}
@PostMapping("/login")
public String Login(String username,String password,Model model)
{
	if(loginservice.Login(username,password))
	{
	return "Home";
	}
	else
	{
		model.addAttribute("error", "Invalid Credentials");
		return "login";
	}
}
@GetMapping("/logout")
public String logout()
{
	return "redirect:/login";
}
}

