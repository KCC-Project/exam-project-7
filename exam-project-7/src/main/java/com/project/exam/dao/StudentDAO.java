package com.project.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.exam.model.StudentsModel;


public interface StudentDAO {
	public List<StudentsModel> getStudentList();
	public StudentsModel addStudent(StudentsModel student);
	public StudentsModel getStudent(int s_Id);
	public StudentsModel updateStudent(StudentsModel student);
	public int deleteStudent(int s_Id);

	
}
