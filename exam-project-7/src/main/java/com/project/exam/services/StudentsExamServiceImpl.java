package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.StudentsExamDAO;
import com.project.exam.model.StudentsExam;

@Service
public class StudentsExamServiceImpl implements StudentsExamService {

	@Autowired
	StudentsExamDAO studentExamDao;
	@Override
	public List<StudentsExam> getstudentsExam() {
	return studentExamDao.getstudentsExamList();
	}

	@Override
	public StudentsExam addstudentsExam(StudentsExam studentsExam) {
		// TODO Auto-generated method stub
		return studentExamDao.addstudentsExam(studentsExam);
	}

	@Override
	public StudentsExam getstudentsExam(int s_Id) {
		// TODO Auto-generated method stub
		return studentExamDao.getstudentsExam(s_Id);
	}

	@Override
	public StudentsExam updatestudentsExam(StudentsExam studentsExam) {
		// TODO Auto-generated method stub
		return studentExamDao.updatestudentsExam(studentsExam);
	}

	@Override
	public int deletestudentsExam(int s_Id) {
		// TODO Auto-generated method stub
		return studentExamDao.deletestudentsExam(s_Id);
	}

}