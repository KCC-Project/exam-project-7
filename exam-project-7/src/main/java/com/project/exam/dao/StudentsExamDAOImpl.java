package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.exam.model.StudentsExam;

@Repository("studentExamDao")
public class StudentsExamDAOImpl implements StudentsExamDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<StudentsExam> getstudentsExamList() {
		Session session = sessionFactory.getCurrentSession();
		List<StudentsExam> studentsExam = session.createCriteria(StudentsExam.class).list();
		return studentsExam;
	}

	@Override
	public StudentsExam addstudentsExam(StudentsExam studentsExam) {
		Session session = sessionFactory.getCurrentSession();
		session.save(studentsExam);
		return studentsExam;
	}

	@Override
	public StudentsExam getstudentsExam(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		StudentsExam studentsExam =  session.get(StudentsExam.class, s_Id);
		
		return studentsExam;
	}

	@Override
	public StudentsExam updatestudentsExam(StudentsExam studentsExam) {
		Session session = sessionFactory.getCurrentSession();
		session.update(studentsExam);
		return studentsExam;
	}

	@Override
	public int deletestudentsExam(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		StudentsExam ent = session.load(StudentsExam.class, s_Id);
		session.delete(ent);
		return 1;
	}


}
