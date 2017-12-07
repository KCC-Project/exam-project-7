package com.project.exam.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/")
public class MainController {

	@GET
	public Viewable index() {
		return new Viewable("/home");
	}
	@GET
	@Path("/home")
	public Viewable home() {
		return new Viewable("/home");
	}
	
	@GET
	@Path("/user")
	public Viewable student() {
		return new Viewable("/student/student-home");
	}
	@GET
	@Path("/user/profile")
	public Viewable profile() {
		return new Viewable("/student/student-profile");
	}
	
	@GET
	@Path("/subject/addNew")
	public Viewable addSubject() {
		return new Viewable("/admin/subject-management/addNewSubject");
	}
	
	@GET
	@Path("/subject/view")
	public Viewable viewSubject() {
		System.out.println("inside Viewable: view subject");
		return new Viewable("/admin/subject-management/viewSubject");
	}
	
	@GET
	@Path("/faculty")
	public Viewable faculty() {
		System.out.println("Insdie view");
		Map<String, Boolean> model = new HashMap<>();
		model.put("faculty_clicked", true);
		return new Viewable("/admin/student-management/faculty", model);
	}
	
	@GET
	@Path("/program")
	public Viewable program() {
		System.out.println("Insdie program");
		Map<String, Boolean> model = new HashMap<>();
		model.put("program_clicked", true);
		return new Viewable("/admin/student-management/program", model);
	}
	

	@GET
	@Path("/student/view")
	public Viewable view() {
		System.out.println("Insdie view");
		Map<String, Boolean> model = new HashMap<>();
		model.put("student_view_clicked", true);
		return new Viewable("/admin/student-management/viewAllStudents", model);
	}
	
	
	@GET
	@Path("/student/addNew")
	public Viewable addNew() {
		System.out.println("Add New Student view");
		Map<String, Boolean> model = new HashMap<>();
		model.put("student_addNew_clicked", true);
		return new Viewable("/admin/student-management/addNew", model);
	}

	@GET
	@Path("/viewexam")
	public Viewable manageExam() {
		System.out.println("Insdie manage-exam");
		Map<String, Boolean> model = new HashMap<>();
		model.put("manage-exam_clicked", true);
		return new Viewable("/admin/exam-management/viewExam", model);
	}
	
	@GET
	@Path("/exam-type")
	public Viewable examType() {
		System.out.println("Insdie exam-type");
		Map<String, Boolean> model = new HashMap<>();
		model.put("exam-type_clicked", true);
		return new Viewable("/admin/exam-management/exam-type", model);
	}
	
	@GET
	@Path("/student-exam")
	public Viewable studentexam() {
		System.out.println("Insdie student-exam");
		Map<String, Boolean> model = new HashMap<>();
		model.put("student-exam_clicked", true);
		return new Viewable("/admin/exam-management/student-exam", model);
	}
	
	@GET
	@Path("/view-admin")
	public Viewable admin() {
		System.out.println("Insdie admin");
		Map<String, Boolean> model = new HashMap<>();
		model.put("admin-type_clicked", true);
		return new Viewable("/admin/admin-management/view-admin", model);
	}
}
