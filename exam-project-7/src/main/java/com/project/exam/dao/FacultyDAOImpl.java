package com.project.exam.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Faculty;

@Repository("FacultyDao")
public class FacultyDAOImpl implements FacultyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Faculty> getFacultyList() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Faculty> faculty = session.createCriteria(Faculty.class).list();
		for (Faculty faculty1 : faculty) {
			System.out.println(faculty1);
			Hibernate.initialize((faculty1.getProgram()));
		}
		return faculty;
	}

	@Override
	@Transactional
	public Faculty addFaculty(Faculty faculty) {
		Session session = sessionFactory.getCurrentSession();
		session.save(faculty);
		return faculty;
	}

	@Override
	@Transactional
	public Faculty getFaculty(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Faculty faculty =  session.get(Faculty.class, s_Id);
		Hibernate.initialize((faculty.getProgram()));
		return faculty;
	}

	@Override
	@Transactional
	public Faculty updateFaculty(Faculty faculty) {
		Session session = sessionFactory.getCurrentSession();
		session.update(faculty);
		return faculty;
	}

	@Override
	@Transactional
	public int deleteFaculty(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Faculty ent = session.load(Faculty.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
