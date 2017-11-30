package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Department;
import com.project.exam.model.StudentsModel;

@Repository("departmentDao")
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Department> getDepartmentList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Department.class).list();
	}

	@Override
	@Transactional
	public Department addDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		session.save(department);
		return department;
	}

	@Override
	@Transactional
	public Department getDepartment(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Department) session.get(Department.class, s_Id);
	}

	@Override
	@Transactional
	public Department updateDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		session.update(department);
		return department;
	}

	@Override
	@Transactional
	public int deleteDepartment(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Department ent = session.load(Department.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
