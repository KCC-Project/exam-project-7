package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.DepartmentDAO;
import com.project.exam.model.Departments;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDAO departmentDao;
	
	@Override
	public List<Departments> getDepartmentList() {
	return departmentDao.getDepartmentList();
	}

	@Override
	public Departments addDepartment(Departments department) {
		return departmentDao.addDepartment(department);
	}

	@Override
	public Departments getDepartment(int s_Id) {
		return departmentDao.getDepartment(s_Id);
	}

	@Override
	public Departments updateDepartment(Departments department) {
		return departmentDao.updateDepartment(department);
	}

	@Override
	public int deleteDepartment(int s_Id) {
		return departmentDao.deleteDepartment(s_Id);
	}

}
