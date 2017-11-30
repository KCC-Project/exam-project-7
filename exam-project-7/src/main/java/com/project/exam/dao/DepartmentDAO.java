package com.project.exam.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.Departments;

public interface DepartmentDAO 
{
	public List<Departments> getDepartmentList();
	public Departments addDepartment(Departments department);
	public Departments getDepartment(int s_Id);
	public Departments updateDepartment(Departments department);
	public int deleteDepartment(int s_Id);

}
