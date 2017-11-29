package com.project.exam.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.exam.model.SubjectModel;


public interface SubjectDAO {
	public List<SubjectModel> getallSubjectList();
	public SubjectModel addStudent(SubjectModel subject);
	public SubjectModel getSubject(int s_Id);
	public SubjectModel updateSubject(SubjectModel subject);
	public int deleteSubject(int s_Id);

}
