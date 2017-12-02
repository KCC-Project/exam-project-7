package com.project.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
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
	List<Student> student=session.createCriteria(Student.class).list();

	//forcing hibernate to pull --- before transaction closes
	for (Student student2 : student) {
		Hibernate.initialize((student2.getStudentProgram()));
		Hibernate.initialize((student2.getStudentsExams()));
	}
		return student;
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
		Student student=(Student)session.get(Student.class, s_Id);
		Hibernate.initialize(student.getStudentProgram());
		Hibernate.initialize(student.getStudentsExams());
		return student;
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

	@Override
	@Transactional
	public List<Object> searchStudent(String searchPara) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session
				.createSQLQuery("SELECT * FROM students WHERE MATCH(first_name, middle_name, last_name) AGAINST('"
						+ searchPara + "' IN NATURAL LANGUAGE MODE)")
				.addEntity(Student.class);
		
		List listOfReslut = new ArrayList<>();
		List<Student> list = query.list();
		
		for (Student student : list) {
			Map<String, Object> map = new HashMap<>();
			Student s = new Student();
			String name = null;
			try {
				if (student.getMiddle_name()== null) {
					name = student.getFirst_name() + " " + student.getLast_name();
				} else {
					name = student.getFirst_name() + " " + student.getMiddle_name() + " " + student.getLast_name();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			map.put("id", student.getS_id());
			map.put("name", name);
			listOfReslut.add(map);
		}

		return listOfReslut;
	}

}
