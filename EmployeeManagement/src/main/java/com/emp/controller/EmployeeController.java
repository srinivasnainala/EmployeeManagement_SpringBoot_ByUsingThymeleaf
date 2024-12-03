package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@Controller
public class EmployeeController {
@Autowired
EmployeeService employeeservice;
@GetMapping("/employee")
public String getEmployees(Model model)
{
	model.addAttribute("employees",employeeservice.getEmployees());
	return "employee";
}
@GetMapping("/employee/add")
public String createEmp(Model model)
{
	Employee employee=new Employee();
	model.addAttribute("employee",employee);
	return "add_employee";
}
@PostMapping("/employee")
public String addEmployee(@ModelAttribute("employee") Employee employee)
{
	employeeservice.addEmployee(employee);
	return "redirect:/employee";
}

@GetMapping("/employee/update/{id}")
public String update(@PathVariable int id,Model model)
{
	model.addAttribute("employee",employeeservice.updateEmp(id));
	return "update_employee";
}
@PostMapping("/employee/{id}")
public String UpdateEmployee(@PathVariable int id,@ModelAttribute("employee") Employee employee,Model model)
{
	employeeservice.updateEmployee(id,employee);
	return "redirect:/employee";
}
@GetMapping("/employee/{id}")
public String DeleteEmployee(@PathVariable int id)
{
	employeeservice.deleteEmployee(id);
	return "redirect:/employee";
}
}
