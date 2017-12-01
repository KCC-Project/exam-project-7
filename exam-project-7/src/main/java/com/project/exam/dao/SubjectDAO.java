package com.project.exam.dao;

import java.util.List;

import com.project.exam.model.Subject;


public interface SubjectDAO {
	public List<Subject> getallSubjectList();
	public Subject addStudent(Subject subject);
	public Subject getSubject(int s_Id);
	public Subject updateSubject(Subject subject);
	public int deleteSubject(int s_Id);

}
