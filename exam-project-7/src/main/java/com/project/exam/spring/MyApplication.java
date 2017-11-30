package com.project.exam.spring;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import org.glassfish.jersey.servlet.ServletProperties;

import com.project.exam.controller.DepartmentController;
import com.project.exam.controller.MainController;
import com.project.exam.controller.ProgramController;
import com.project.exam.controller.StudentController;
import com.project.exam.controller.SubjectController;



public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication() {
      
     register(JspMvcFeature.class);
     property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
     property(ServletProperties.FILTER_STATIC_CONTENT_REGEX,
             // "/(images|css)/.*");
             "/css/*");
     
      register(MainController.class);
      register(StudentController.class);
      register(SubjectController.class);
      register(ProgramController.class);
      register(DepartmentController.class);
      
   
    }
}
