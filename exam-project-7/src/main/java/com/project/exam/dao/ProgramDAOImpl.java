package com.project.exam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
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
		List<Program> program = session.createCriteria(Program.class).list();
		List<Program> program2= new ArrayList<>();
		for (Program program1 : program) {
			
			
			
			Program pr= new Program();
			pr.setProgram_id(program1.getProgram_id());
			pr.setProgram_name(program1.getProgram_name());
			pr.setProgram_years(program1.getProgram_years());
			pr.setTotal_credit(program1.getTotal_credit());
			pr.setStatus(program1.getStatus());
			pr.setFaculty(program1.getFaculty());
			program2.add(pr);
			
			Hibernate.initialize((program1.getStudentsProgram()));
			//Hibernate.initialize((program1.getFaculty()));
			Hibernate.initialize((program1.getSubject()));
		}
		return program2;
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
		Program program =  session.get(Program.class, s_Id);
		Hibernate.initialize((program.getStudentsProgram()));
		//Hibernate.initialize((program.getFaculty()));
		Hibernate.initialize((program.getSubject()));
		
		Program pr= new Program();
		pr.setProgram_id(program.getProgram_id());
		pr.setProgram_name(program.getProgram_name());
		pr.setProgram_years(program.getProgram_years());
		pr.setTotal_credit(program.getTotal_credit());
		pr.setStatus(program.getStatus());
		pr.setFaculty(program.getFaculty());
		
		
		return pr;
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
