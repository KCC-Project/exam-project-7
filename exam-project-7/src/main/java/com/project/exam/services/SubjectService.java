package com.project.exam.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.Subject;

@Component
public interface SubjectService {
	
	public List<Subject> getallSubjectList();
	public Subject addSubject(Subject subject);
	public Subject getSubject(int s_Id);
	public Subject updateSubject(Subject subject);
	public int deleteSubject(int s_Id);

}
