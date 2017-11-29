package com.project.exam.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.SubjectModel;

@Component
public interface SubjectService {
	
	public List<SubjectModel> getallSubjectList();
	public SubjectModel addSubject(SubjectModel subject);
	public SubjectModel getSubject(int s_Id);
	public SubjectModel updateSubject(SubjectModel subject);
	public int deleteSubject(int s_Id);

}
