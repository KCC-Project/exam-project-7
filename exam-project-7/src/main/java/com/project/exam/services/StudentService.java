package com.project.exam.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.StudentsModel;

@Component
public interface StudentService {
	
	public List<StudentsModel> getStudentList();
	public StudentsModel addStudent(StudentsModel student);
	public StudentsModel getStudent(int s_Id);


}
