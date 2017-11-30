package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Departments;

@Repository("departmentDao")
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Departments> getDepartmentList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Departments.class).list();
	}

	@Override
	@Transactional
	public Departments addDepartment(Departments department) {
		Session session = sessionFactory.getCurrentSession();
		session.save(department);
		return department;
	}

	@Override
	@Transactional
	public Departments getDepartment(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Departments) session.get(Departments.class, s_Id);
	}

	@Override
	@Transactional
	public Departments updateDepartment(Departments department) {
		Session session = sessionFactory.getCurrentSession();
		session.update(department);
		return department;
	}

	@Override
	@Transactional
	public int deleteDepartment(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Departments ent = session.load(Departments.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
