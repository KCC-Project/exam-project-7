package com.project.exam.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Exam;

@Repository("examDao")
public class ExamDAOImpl implements ExamDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Exam> getExamList() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Exam> exam = session.createCriteria(Exam.class).list();
		for (Exam exam1 : exam) {
			Hibernate.initialize((exam1.getExam_types()));
			Hibernate.initialize((exam1.getSubjects()));
		}
		return exam;
	}

	@Override
	@Transactional
	public Exam addExam(Exam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.save(exam);
		return exam;
	}

	@Override
	@Transactional
	public Exam getExam(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Exam exam =  session.get(Exam.class, s_Id);
		Hibernate.initialize((exam.getExam_types()));
		Hibernate.initialize((exam.getSubjects()));
		return exam;
	}

	@Override
	@Transactional
	public Exam updateExam(Exam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.update(exam);
		return exam;
	}

	@Override
	@Transactional
	public int deleteExam(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Exam ent = session.load(Exam.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
