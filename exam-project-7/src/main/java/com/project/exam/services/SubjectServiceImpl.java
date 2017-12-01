package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.SubjectDAO;
import com.project.exam.model.Subject;
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectDAO subjectDao;
	
	@Override
	public List<Subject> getallSubjectList() {
		return subjectDao.getallSubjectList();
	}

	@Override
	public Subject addSubject(Subject subject) {
		return subjectDao.addStudent(subject);
	}

	@Override
	public Subject getSubject(int s_Id) {
		return subjectDao.getSubject(s_Id);
	}

	@Override
	public Subject updateSubject(Subject subject) {
		return subjectDao.updateSubject(subject);
	}

	@Override
	public int deleteSubject(int s_Id) {
		return subjectDao.deleteSubject(s_Id);
	}

}
