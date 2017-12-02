package com.project.exam.dao;

import java.util.List;

import javax.security.auth.Subject;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Program;
import com.project.exam.model.Subjects;



@Repository("subjectDao")
public class SubjectDAOImpl implements SubjectDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Subjects> getallSubjectList() {
		Session session = sessionFactory.getCurrentSession();
		List<Subjects> subject = session.createCriteria(Subjects.class).list();
		for (Subjects subject1 : subject) {
			Hibernate.initialize((subject1.getExams()));
			Hibernate.initialize((subject1.getSemesterSubjects()));
		}
		return subject;

	
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
		Subjects subject = session.get(Subjects.class, s_Id);
		Hibernate.initialize((subject.getExams()));
		Hibernate.initialize((subject.getSemesterSubjects()));
		return subject;
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
