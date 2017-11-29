package com.project.exam.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.exam.model.StudentsModel;
import com.project.exam.services.StudentService;

@Path("/ApiStudent")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GET
	@Path("/GetAllStudent")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<StudentsModel> getAllStudent() {
		return studentService.getStudentList();
	}
	
	
	@POST
	@Path("/SaveStudent")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsModel getAllStudent(StudentsModel studentModel) {
		return studentService.addStudent(studentModel);
	}
	

	@GET
	@Path("/GetStudent/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsModel getStudent(@javax.ws.rs.PathParam("id") int id) {
		return studentService.getStudent(1);
	}
	
	
}
