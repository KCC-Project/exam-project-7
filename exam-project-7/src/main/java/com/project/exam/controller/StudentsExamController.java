package com.project.exam.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.exam.model.StudentsExam;
import com.project.exam.services.StudentsExamService;

@Path("/ApiStudentsExams")
public class StudentsExamController {
	@Autowired
	private StudentsExamService studentsExamService;

	@GET
	@Path("/GetAllStudentsExams")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<StudentsExam> getAllStudentsExam() {
		System.out.println("indiseee");
		return studentsExamService.getstudentsExam();
	}
	
	
	@POST
	@Path("/SaveStudentsExam")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsExam saveStudentsExam(StudentsExam studentsExamModel) {
		return studentsExamService.addstudentsExam(studentsExamModel);
	}
	

	@GET
	@Path("/GetStudentsExams/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsExam getStudentsExam(@PathParam("id") int id) {
		return studentsExamService.getstudentsExam(id);
	}
	
	@PUT
	@Path("/UpdateStudentsExam")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public StudentsExam updateStudentsExam(StudentsExam studentsExamModel) {
		return studentsExamService.updatestudentsExam(studentsExamModel);
	}
	
	@DELETE
	@Path("/DeleteStudentsExam/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public int deleteStudentsExamsModel(@PathParam("id") int id) {
		return studentsExamService.deletestudentsExam(id);
	}
	
	
	@POST
	@Path("/GetRequiredInfoTOSave")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void getRequiredInfoTOSave(@FormParam("a_program_id") int a_program_id,@FormParam("examTypeId") int examTypeId,@FormParam("semester_no") int semester_no) {
	System.out.println("a_program_id examTypeId semester_no"+a_program_id+examTypeId+semester_no);
	System.out.println("Hereeeeeeeeeeeeeeeeeeemausam");
	 studentsExamService.getRequiredInfoTOSave(a_program_id, examTypeId, semester_no);
	}
		
}
