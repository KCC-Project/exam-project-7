package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Faculty;

@Repository("departmentDao")
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Faculty> getDepartmentList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Faculty.class).list();
	}

	@Override
	@Transactional
	public Faculty addDepartment(Faculty department) {
		Session session = sessionFactory.getCurrentSession();
		session.save(department);
		return department;
	}

	@Override
	@Transactional
	public Faculty getDepartment(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Faculty) session.get(Faculty.class, s_Id);
	}

	@Override
	@Transactional
	public Faculty updateDepartment(Faculty department) {
		Session session = sessionFactory.getCurrentSession();
		session.update(department);
		return department;
	}

	@Override
	@Transactional
	public int deleteDepartment(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Faculty ent = session.load(Faculty.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
