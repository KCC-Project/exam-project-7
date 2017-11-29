package com.project.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.StudentsModel;

@Repository("studentDao")

public class StudentDAOImpl implements StudentDAO {

	private static List<StudentsModel> students = new ArrayList();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<StudentsModel> getStudentList() {
		StudentsModel m= new StudentsModel();
		Session session= sessionFactory.getCurrentSession();
		return  session.createCriteria(StudentsModel.class).list();
		
	}

	@Override
	@Transactional
	public StudentsModel addStudent(StudentsModel student) {
		Session session= sessionFactory.getCurrentSession();
		System.out.println(student.toString());
		session.save(student);
		return student;
	}

	@Override
	@Transactional
	public StudentsModel getStudent(int s_Id) {
		Session session= sessionFactory.getCurrentSession();
		return  session.load(StudentsModel.class, s_Id);
	}

}
