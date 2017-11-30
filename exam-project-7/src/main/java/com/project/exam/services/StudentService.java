package com.project.exam.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.Students;

@Component
public interface StudentService {
	
	public List<Students> getStudentList();
	public Students addStudent(Students student);
	public Students getStudent(int s_Id);
	public Students updateStudent(Students student);
	public int deleteStudent(int s_Id);

}
