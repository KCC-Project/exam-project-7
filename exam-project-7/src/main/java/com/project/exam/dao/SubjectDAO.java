package com.project.exam.dao;

import java.util.List;

import com.project.exam.model.Subjects;


public interface SubjectDAO {
	public List<Subjects> getallSubjectList();
	public Subjects addStudent(Subjects subject);
	public Subjects getSubject(int s_Id);
	public Subjects updateSubject(Subjects subject);
	public int deleteSubject(int s_Id);

}
