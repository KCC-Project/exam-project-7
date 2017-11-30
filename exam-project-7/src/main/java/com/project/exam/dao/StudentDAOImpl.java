package com.project.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Students;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {



	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Students> getStudentList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Students.class).list();

	}

	@Override
	@Transactional
	public Students addStudent(Students student) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(student.toString());
		session.save(student);
		return student;
	}

	@Override
	@Transactional
	public Students getStudent(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Students) session.get(Students.class, s_Id);
	}

	@Override
	@Transactional
	public Students updateStudent(Students student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
		return student;
	}

	@Override
	@Transactional
	public int deleteStudent(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Students ent = session.load(Students.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
