package com.stu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stu.model.Student;
import com.stu.service.StudentService;

@Controller
public class StudentController {
@Autowired
StudentService studentservice;

//getting student details
@GetMapping("/student")
public String getStudent(Model model)
{
    model.addAttribute("student", studentservice.getStudents());	
	return "student";
}

//Adding student
@GetMapping("/student/add")
public String addStudent(Model model)
{
	Student student=new Student();
	model.addAttribute("student",student);
	return "add_Student";
}
@PostMapping("/student")
public String addstudent(@ModelAttribute("students") Student student)
{
	studentservice.addstudent(student);
	return "redirect:/student";
}

//Updating student details
@GetMapping("/student/update/{id}")
public String updateSt(@PathVariable int id,Model model)
{
	model.addAttribute("students",studentservice.update(id));
	return "update_Student";
}
@PostMapping("/student/{id}") 
public String updateStudent(@PathVariable int id,@ModelAttribute("students")Student student)
{
	studentservice.updateStudent(id,student);
	System.out.println("Successfully Updated");

	return "redirect:/student";
}

//Deleting student details
@GetMapping("/student/delete/{id}") 
public String deleteStudent(@PathVariable int id)
{
	studentservice.deleteStudent(id);
	System.out.println("Successfully deleted");
	return "redirect:/student";
}

}
