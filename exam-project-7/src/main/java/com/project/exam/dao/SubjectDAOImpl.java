package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Subject;



@Repository("subjectDao")
public class SubjectDAOImpl implements SubjectDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Subject> getallSubjectList() {
		Session session = sessionFactory.getCurrentSession();
		//SubjectModel model= new SubjectModel(10,"asdf","as",1,2,1,2,1,2,"asdf",12);
		//session.save(model);
		return session.createCriteria(Subject.class).list();
	
	}

	@Override
	@Transactional
	public Subject addStudent(Subject subjectModel) {
		Session session = sessionFactory.getCurrentSession();
		session.save(subjectModel);
		return subjectModel;
	}

	@Override
	@Transactional
	public Subject getSubject(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Subject) session.get(Subject.class, s_Id);
	}

	@Override
	@Transactional
	public Subject updateSubject(Subject subject) {
		Session session = sessionFactory.getCurrentSession();
		session.update(subject);
		return subject;
	}

	@Override
	@Transactional
	public int deleteSubject(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Subject ent = session.load(Subject.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
