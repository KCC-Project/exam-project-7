package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.StudentsProgram;

@Repository("/studemtsProgramDao")
public class StudentsProgramDAOImpl implements StudentsProgramDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<StudentsProgram> getStudentsProgramList() {
		Session session = sessionFactory.getCurrentSession();
		
		List<StudentsProgram> studentsProgram = session.createCriteria(StudentsProgram.class).list();
		
		return studentsProgram;
	}

	@Override
	@Transactional
	public StudentsProgram addStudentsProgram(StudentsProgram studentsProgram) {
		Session session = sessionFactory.getCurrentSession();
		session.save(studentsProgram);
		return studentsProgram;
	}

	@Override
	@Transactional
	public StudentsProgram getStudentsProgram(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		StudentsProgram studentsProgram =  session.get(StudentsProgram.class, s_Id);
	
		return studentsProgram;
	}

	@Override
	@Transactional
	public StudentsProgram updateStudentsProgram(StudentsProgram studentsProgram) {
		Session session = sessionFactory.getCurrentSession();
		session.update(studentsProgram);
		return studentsProgram;
	}

	@Override
	@Transactional
	public int deleteStudentsProgram(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		StudentsProgram ent = session.load(StudentsProgram.class, s_Id);
		session.delete(ent);
		return 1;
	}
}
