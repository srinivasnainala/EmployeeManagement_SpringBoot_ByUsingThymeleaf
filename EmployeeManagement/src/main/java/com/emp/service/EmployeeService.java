package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepo;

@Service
public class EmployeeService {
@Autowired
EmployeeRepo employeerepo;

public List<Employee> getEmployees() {
	return employeerepo.findAll();
}

public Employee addEmployee(Employee employee) {
	return employeerepo.save(employee);
}

public Employee updateEmp(int id) {
	
	return employeerepo.findById(id).get();
}



public Employee updateEmployee(int id, Employee employee) {
	Employee e=employeerepo.findById(id).get();;
	e.setFirstname(employee.getFirstname());
	e.setLastname(employee.getLastname());
	e.setMobilenumber(employee.getMobilenumber());
	return employeerepo.save(e);
	
}

public void deleteEmployee(int id) {
employeerepo.deleteById(id);	
}

}
