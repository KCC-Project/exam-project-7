package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.DepartmentDAO;
import com.project.exam.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDAO departmentDao;
	
	@Override
	public List<Department> getDepartmentList() {
	return departmentDao.getDepartmentList();
	}

	@Override
	public Department addDepartment(Department department) {
		return departmentDao.addDepartment(department);
	}

	@Override
	public Department getDepartment(int s_Id) {
		return departmentDao.getDepartment(s_Id);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentDao.updateDepartment(department);
	}

	@Override
	public int deleteDepartment(int s_Id) {
		return departmentDao.deleteDepartment(s_Id);
	}

}
