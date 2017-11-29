package com.project.exam.services;

import java.util.List;

import com.project.exam.model.SubjectModel;


public interface SubjectService {
	
	public List<SubjectModel> getallSubjectList();
	public SubjectModel addSubject(SubjectModel subject);
	public SubjectModel getSubject(int s_Id);


}
