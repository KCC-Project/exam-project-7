package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Department;
import com.project.exam.model.Programs;

@Repository("programDao")
public class ProgramDAOImpl implements ProgramDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Programs> getProgramList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Programs.class).list();
	}

	@Override
	@Transactional
	public Programs addProgram(Programs program) {
		Session session = sessionFactory.getCurrentSession();
		session.save(program);
		return program;
	}

	@Override
	@Transactional
	public Programs getProgram(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Programs) session.get(Programs.class, s_Id);
		}

	@Override
	@Transactional
	public Programs updateProgram(Programs program) {
		Session session = sessionFactory.getCurrentSession();
		session.update(program);
		return program;
	}

	@Override
	@Transactional
	public int deleteProgram(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Programs ent = session.load(Programs.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
