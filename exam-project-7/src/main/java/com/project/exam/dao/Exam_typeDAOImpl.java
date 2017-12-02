package com.project.exam.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Exam_type;

@Repository("exam_TypeDao")
public class Exam_typeDAOImpl implements Exam_typeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Exam_type> getExam_typeList() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Exam_type> exam_type = session.createCriteria(Exam_type.class).list();
		for (Exam_type exam_type1 : exam_type) {
			Hibernate.initialize((exam_type1.getExam_type_id()));
		}
		return exam_type;
	}

	@Override
	@Transactional
	public Exam_type addExam_type(Exam_type exam_type) {
		Session session = sessionFactory.getCurrentSession();
		session.save(exam_type);
		return exam_type;
	}

	@Override
	@Transactional
	public Exam_type getExam_type(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Exam_type exam_type =  session.get(Exam_type.class, s_Id);
		Hibernate.initialize((exam_type.getExam_type_id()));
		return exam_type;
	}

	@Override
	@Transactional
	public Exam_type updateExam_type(Exam_type exam_type) {
		Session session = sessionFactory.getCurrentSession();
		session.update(exam_type);
		return exam_type;
	}

	@Override
	@Transactional
	public int deleteExam_type(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Exam_type ent = session.load(Exam_type.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
