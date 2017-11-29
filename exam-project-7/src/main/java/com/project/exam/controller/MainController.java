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
	    	System.out.println("heloow");
	       
	    	 return new Viewable("/home");
	 
	}	
}
