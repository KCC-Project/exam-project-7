package com.project.exam.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.exam.model.Departments;
import com.project.exam.services.DepartmentService;

@Path("/ApiDepartment")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GET
	@Path("/GetAllDepartment")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Departments> getAllDepartment() {
		return departmentService.getDepartmentList();
	}
	
	
	@POST
	@Path("/SaveDepartment")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Departments saveDepartment(Departments department) {
		return departmentService.addDepartment(department);
	}
	

	@GET
	@Path("/GetDepartment/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Departments getDepartment(@PathParam("id") int id) {
		return departmentService.getDepartment(id);
	}
	
	@PUT
	@Path("/UpdateDepartment")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Departments updateDepartment(Departments department) {
		return departmentService.updateDepartment(department);
	}
	
	@DELETE
	@Path("/DeleteDepartment/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public int deleteDepartment(@PathParam("id") int id) {
		return departmentService.deleteDepartment(id);
	}
	
	
}
