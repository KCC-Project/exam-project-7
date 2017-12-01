package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Faculty;
import com.project.exam.model.Program;

@Repository("programDao")
public class ProgramDAOImpl implements ProgramDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Program> getProgramList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Program.class).list();
	}

	@Override
	@Transactional
	public Program addProgram(Program program) {
		Session session = sessionFactory.getCurrentSession();
		session.save(program);
		return program;
	}

	@Override
	@Transactional
	public Program getProgram(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		return (Program) session.get(Program.class, s_Id);
		}

	@Override
	@Transactional
	public Program updateProgram(Program program) {
		Session session = sessionFactory.getCurrentSession();
		session.update(program);
		return program;
	}

	@Override
	@Transactional
	public int deleteProgram(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Program ent = session.load(Program.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
