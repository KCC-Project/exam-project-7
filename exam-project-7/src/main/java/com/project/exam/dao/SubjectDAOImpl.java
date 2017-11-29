package com.project.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.exam.model.SubjectModel;

@Repository("subjectDao")
public class SubjectDAOImpl implements SubjectDAO {

	private static List<SubjectModel> students = new ArrayList();

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<SubjectModel> getallSubjectList() {
		Session session = sessionFactory.getCurrentSession();
		//SubjectModel model= new SubjectModel(10,"asdf","as",1,2,1,2,1,2,"asdf",12);
		//session.save(model);
		return session.createCriteria(SubjectModel.class).list();
	
	}

	@Override
	@Transactional
	public SubjectModel addStudent(SubjectModel subjectModel) {
		Session session = sessionFactory.getCurrentSession();
		session.save(subjectModel);
		return subjectModel;
	}

	@Override
	@Transactional
	public SubjectModel getSubject(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (SubjectModel) session.get(SubjectModel.class, s_Id);
	}

	@Override
	@Transactional
	public SubjectModel updateSubject(SubjectModel subject) {
		Session session = sessionFactory.getCurrentSession();
		session.update(subject);
		return subject;
	}

	@Override
	@Transactional
	public int deleteSubject(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		SubjectModel ent = session.load(SubjectModel.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
