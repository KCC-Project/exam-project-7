package com.project.exam.services;

import java.util.List;

import com.project.exam.model.Department;

public interface DepartmentService {
	public List<Department> getDepartmentList();
	public Department addDepartment(Department department);
	public Department getDepartment(int s_Id);
	public Department updateDepartment(Department department);
	public int deleteDepartment(int s_Id);
}
