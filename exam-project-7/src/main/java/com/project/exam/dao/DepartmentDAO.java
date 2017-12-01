package com.project.exam.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.exam.model.Faculty;

public interface DepartmentDAO 
{
	public List<Faculty> getDepartmentList();
	public Faculty addDepartment(Faculty department);
	public Faculty getDepartment(int s_Id);
	public Faculty updateDepartment(Faculty department);
	public int deleteDepartment(int s_Id);

}
