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

}
