package com.project.exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Admin;

@Repository("adminDao")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Admin> getAdminList() {
		Session session = sessionFactory.getCurrentSession();
		List<Admin> admin = session.createCriteria(Admin.class).list();
		return admin;
	}

	@Override
	@Transactional
	public Admin addAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.save(admin);
		return admin;
	}

	@Override
	@Transactional
	public Admin getAdmin(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin =  session.get(Admin.class, s_Id);
		
		return admin;
	}

	@Override
	@Transactional
	public Admin updateAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.update(admin);
		return admin;
	}

	@Override
	@Transactional
	public int deleteAdmin(int s_Id) {
		Session session = sessionFactory.getCurrentSession();
		Admin ent = session.load(Admin.class, s_Id);
		session.delete(ent);
		return 1;
	}

}
