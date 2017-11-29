package com.project.exam.spring;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.TracingConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import com.project.exam.controller.MainController;



public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication() {
      
     register(JspMvcFeature.class);
     property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
     
      register(MainController.class);
      
   
    }
}
