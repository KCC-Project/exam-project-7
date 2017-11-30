package com.project.exam.services;

import java.util.List;


import org.springframework.stereotype.Component;

import com.project.exam.model.Department;

@Component
public interface DepartmentService {
	public List<Department> getDepartmentList();
	public Department addDepartment(Department department);
	public Department getDepartment(int s_Id);
	public Department updateDepartment(Department department);
	public int deleteDepartment(int s_Id);
}
