package com.project.exam.services;

import java.util.List;


import org.springframework.stereotype.Component;

import com.project.exam.model.Departments;

@Component
public interface DepartmentService {
	public List<Departments> getDepartmentList();
	public Departments addDepartment(Departments department);
	public Departments getDepartment(int s_Id);
	public Departments updateDepartment(Departments department);
	public int deleteDepartment(int s_Id);
}
