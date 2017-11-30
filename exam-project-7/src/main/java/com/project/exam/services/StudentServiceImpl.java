package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.StudentDAO;
import com.project.exam.model.Students;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDao;

	@Override
	public List<Students> getStudentList() {
		return studentDao.getStudentList();
	}

	@Override
	public Students addStudent(Students student) {
		return studentDao.addStudent(student);
	}

	@Override
	public Students getStudent(int s_Id) {
		return studentDao.getStudent(s_Id);
	}

	@Override
	public Students updateStudent(Students student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public int deleteStudent(int s_Id) {
		return studentDao.deleteStudent(s_Id);
	}

	
}
