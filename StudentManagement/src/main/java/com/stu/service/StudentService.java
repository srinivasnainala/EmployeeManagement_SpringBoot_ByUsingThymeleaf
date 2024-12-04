package com.stu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.model.Student;
import com.stu.repository.StudentRepo;

@Service
public class StudentService {
@Autowired
StudentRepo studentrepo;

public List<Student> getStudents() {
	return studentrepo.findAll();
}

public void addstudent(Student student) {
	studentrepo.save(student);
}

public Student update(int id) {
	
	return studentrepo.findById(id).get();
}

public Student updateStudent(int id, Student student) {
	Student st=studentrepo.findById(id).get();
	st.setName(student.getName());
	st.setBranch(student.getBranch());
	st.setMobilenumber(student.getMobilenumber());
	return studentrepo.save(st);
}

public void deleteStudent(int id) {
studentrepo.deleteById(id);	
}
}
