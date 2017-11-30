package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Subjects;



@Repository("subjectDao")
public class SubjectDAOImpl implements SubjectDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Subjects> getallSubjectList() {
		Session session = sessionFactory.getCurrentSession();
		//SubjectModel model= new SubjectModel(10,"asdf","as",1,2,1,2,1,2,"asdf",12);
		//session.save(model);
		return session.createCriteria(Subjects.class).list();
	
	}

	@Override
	@Transactional
	public Subjects addStudent(Subjects subjectModel) {
		Session session = sessionFactory.getCurrentSession();
		session.save(subjectModel);
		return subjectModel;
	}

	@Override
	@Transactional
	public Subjects getSubject(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Subjects) session.get(Subjects.class, s_Id);
	}

	@Override
	@Transactional
	public Subjects updateSubject(Subjects subject) {
		Session session = sessionFactory.getCurrentSession();
		session.update(subject);
		return subject;
	}

	@Override
	@Transactional
	public int deleteSubject(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Subjects ent = session.load(Subjects.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
