package com.project.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.exam.model.StudentsModel;

@Repository("studentDao")

public class StudentDAOImpl implements StudentDAO {

	private static List<StudentsModel> students = new ArrayList();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<StudentsModel> getStudentList() {
		StudentsModel m= new StudentsModel();
		StudentsModel m1= new StudentsModel();
		
		m.setS_id(1);
		m.setFirst_name("shrawan");
		m.setMiddle_name("");
		m.setLast_name("Adhikari");
		m.setDate_of_birth("1997-02-07");
		m.setPhone(12345);
		m.setAddress("street 7");
		m.setCity("ktm");
		m.setDistrict("ktm");
		m.setZipcode("55670");
		
		students.add(m);
		
		
		m1.setS_id(1);
		m1.setFirst_name("mausam");
		m1.setMiddle_name("");
		m1.setLast_name("Rayamajhi");
		m1.setDate_of_birth("1997-01-01");
		m1.setPhone(55555);
		m1.setAddress("street 8");
		m1.setCity("ktm");
		m1.setDistrict("ktm");
		m1.setZipcode("55670");
		students.add(m1);
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh");
		return  students;
		
	}

	@Override
	public StudentsModel addStudent(StudentsModel student) {
		Session session= sessionFactory.getCurrentSession();
		
		return (StudentsModel) session.save(student);
	}

	@Override
	public StudentsModel getStudent(int s_Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
