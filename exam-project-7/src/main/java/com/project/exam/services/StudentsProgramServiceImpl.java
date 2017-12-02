package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.StudentsProgramDAO;
import com.project.exam.model.StudentsProgram;

@Service
public class StudentsProgramServiceImpl implements StudentsProgramService {
	@Autowired
	private StudentsProgramDAO StudentsProgramDao;
	
	@Override
	public List<StudentsProgram> getStudentsProgramList() {
	return StudentsProgramDao.getStudentsProgramList();
	}

	@Override
	public StudentsProgram addStudentsProgram(StudentsProgram studentsProgram) {
		return StudentsProgramDao.addStudentsProgram(studentsProgram);
	}

	@Override
	public StudentsProgram getStudentsProgram(int s_Id) {
		return StudentsProgramDao.getStudentsProgram(s_Id);
	}

	@Override
	public StudentsProgram updateStudentsProgram(StudentsProgram studentsProgram) {
		return StudentsProgramDao.updateStudentsProgram(studentsProgram);
	}

	@Override
	public int deleteStudentsProgram(int s_Id) {
		return StudentsProgramDao.deleteStudentsProgram(s_Id);
	}


}
