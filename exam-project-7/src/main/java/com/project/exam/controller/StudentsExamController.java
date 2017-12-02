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

import com.project.exam.model.StudentsExam;
import com.project.exam.services.StudentsExamService;

@Path("/ApiStudentsExamsExam")
public class StudentsExamController {
	@Autowired
	private StudentsExamService StudentsExamService;

	@GET
	@Path("/GetAllStudentsExamsExam")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<StudentsExam> getAllStudentsExam() {
		System.out.println("indiseee");
		return StudentsExamService.getstudentsExam();
	}
	
	
	@POST
	@Path("/SaveStudentsExamsExam")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsExam saveStudentsExam(StudentsExam studentsExamModel) {
		return StudentsExamService.addstudentsExam(studentsExamModel);
	}
	

	@GET
	@Path("/GetStudentsExamsExam/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsExam getStudentsExam(@PathParam("id") int id) {
		return StudentsExamService.getstudentsExam(id);
	}
	
	@PUT
	@Path("/UpdateStudentsExamsExam")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsExam updateStudentsExam(StudentsExam studentsExamModel) {
		return StudentsExamService.updatestudentsExam(studentsExamModel);
	}
	
	@DELETE
	@Path("/DeleteStudentsExam/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public int deleteStudentsExamsModel(@PathParam("id") int id) {
		return StudentsExamService.deletestudentsExam(id);
	}
	
	
	
		
}
