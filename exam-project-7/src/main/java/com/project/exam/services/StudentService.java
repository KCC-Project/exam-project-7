package com.project.exam.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.Student;

@Component
public interface StudentService {
	
	public List<Student> getStudentList();
	public Student addStudent(Student student);
	public Student getStudent(int s_Id);
	public Student updateStudent(Student student);
	public int deleteStudent(int s_Id);
	public Student searchStudent(String searchPara);
}
