package com.project.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Faculty;

@Repository("FacultyDao")
public class FacultyDAOImpl implements FacultyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Faculty> getFacultyList() {
		Session session = sessionFactory.openSession();
		List<Faculty> faculty = session.createCriteria(Faculty.class).list();
		List<Faculty> faculty2= new ArrayList<>();
		
		for (Faculty faculty1 : faculty) {
			//System.out.println("Extra data = "+faculty1.getProgram());
			
			Hibernate.initialize(faculty1.getProgram());
			
			Faculty fa= new Faculty();
			fa.setFaculty_id(faculty1.getFaculty_id());
			fa.setFaculty_name(faculty1.getFaculty_name());
			fa.setStatus(faculty1.getStatus());
			faculty2.add(fa);
		}
		return faculty2;
	}

	@Override
	@Transactional
	public Faculty addFaculty(Faculty faculty) {
		Session session = sessionFactory.getCurrentSession();
		session.save(faculty);
		return faculty;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
	public Faculty getFaculty(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Faculty faculty =  session.get(Faculty.class, s_Id);
	
		Faculty faculty1=new Faculty();
		faculty1.setFaculty_id(faculty.getFaculty_id());
		faculty1.setFaculty_name(faculty.getFaculty_name());
		faculty1.setStatus(faculty.getStatus());
		
	Hibernate.initialize(faculty.getProgram());
	
		return faculty1;
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
