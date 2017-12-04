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

import com.project.exam.model.StudentsProgram;
import com.project.exam.services.StudentsProgramService;

@Path("/ApiStudentsProgram")
public class StudentsProgramController {

	@Autowired
	private StudentsProgramService studentsProgramService;
	
	@GET
	@Path("/GetAllStudentsProgram")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<StudentsProgram> getAllStudentsProgram() {
		return studentsProgramService.getStudentsProgramList();
	}
	
	
	@POST
	@Path("/SaveStudentsProgram")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsProgram saveStudentsProgram(StudentsProgram studentsProgram) {
		return studentsProgramService.addStudentsProgram(studentsProgram);
	}
	

	@GET
	@Path("/GetStudentsProgram/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsProgram getStudentsProgram(@PathParam("id") int id) {
		return studentsProgramService.getStudentsProgram(id);
	}
	
	@PUT
	@Path("/UpdateStudentsProgram")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsProgram updateStudentsProgram(StudentsProgram studentsProgram) {
		return studentsProgramService.updateStudentsProgram(studentsProgram);
	}
	
	@DELETE
	@Path("/DeleteStudentsProgram/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public int deleteStudentsProgram(@PathParam("id") int id) {
		return studentsProgramService.deleteStudentsProgram(id);
	}
	
	@GET
	@Path("/GetStudentsProgramByProgramId/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<StudentsProgram> getStudentsProgramByProgramId(@PathParam("id") int id) {
		return studentsProgramService.getStudentsProgramByProgramId(id);
	}
}
