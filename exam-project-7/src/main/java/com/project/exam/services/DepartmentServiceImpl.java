package com.project.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exam.dao.DepartmentDAO;
import com.project.exam.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Override
	public List<Department> getDepartmentList() {
	return departmentDAO.getDepartmentList();
	}

	@Override
	public Department addDepartment(Department department) {
		return departmentDAO.addDepartment(department);
	}

	@Override
	public Department getDepartment(int s_Id) {
		return departmentDAO.getDepartment(s_Id);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentDAO.updateDepartment(department);
	}

	@Override
	public int deleteDepartment(int s_Id) {
		return departmentDAO.deleteDepartment(s_Id);
	}

}
