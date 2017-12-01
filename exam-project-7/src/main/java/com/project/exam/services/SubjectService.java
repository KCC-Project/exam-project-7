package com.project.exam.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.Subjects;

@Component
public interface SubjectService {
	
	public List<Subjects> getallSubjectList();
	public Subjects addSubject(Subjects subject);
	public Subjects getSubject(int s_Id);
	public Subjects updateSubject(Subjects subject);
	public int deleteSubject(int s_Id);

}
