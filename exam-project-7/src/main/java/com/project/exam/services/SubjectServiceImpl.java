package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.exam.dao.SubjectDAO;
import com.project.exam.model.SubjectModel;
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectDAO subjectDao;
	
	@Override
	public List<SubjectModel> getallSubjectList() {
		return subjectDao.getallSubjectList();
	}

	@Override
	public SubjectModel addSubject(SubjectModel subject) {
		return subjectDao.addStudent(subject);
	}

	@Override
	public SubjectModel getSubject(int s_Id) {
		return subjectDao.getSubject(s_Id);
	}

	@Override
	public SubjectModel updateSubject(SubjectModel subject) {
		return subjectDao.updateSubject(subject);
	}

	@Override
	public int deleteSubject(int s_Id) {
		return subjectDao.deleteSubject(s_Id);
	}

}
