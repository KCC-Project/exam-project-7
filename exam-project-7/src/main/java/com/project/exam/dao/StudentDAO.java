package com.project.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.exam.model.Students;


public interface StudentDAO {
	
	public List<Students> getStudentList();
	public Students addStudent(Students student);
	public Students getStudent(int s_Id);
	public Students updateStudent(Students student);
	public int deleteStudent(int s_Id);

	
}
