package com.project.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Student;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Student> getStudentList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Student.class).list();

	}

	@Override
	@Transactional
	public Student addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(student.toString());
		session.save(student);
		return student;
	}

	@Override
	@Transactional
	public Student getStudent(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Student) session.get(Student.class, s_Id);
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
		return student;
	}

	@Override
	@Transactional
	public int deleteStudent(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Student ent = session.load(Student.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
