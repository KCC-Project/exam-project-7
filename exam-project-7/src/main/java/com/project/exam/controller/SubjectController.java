package com.project.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.exam.model.SubjectModel;
import com.project.exam.services.SubjectService;

@Controller
@RequestMapping("/subject-management")
public class SubjectController {
	
	
	private SubjectService subjectService;
	
	 @RequestMapping("/view")
	 public ModelAndView view() {
			ModelAndView mv = new ModelAndView("subject-management");
			mv.addObject("subject_view_clicked", true);
			mv.addObject("message", "the input form should be here");
			return mv;
		}
	 
	 @RequestMapping("/addNew")
	 public ModelAndView addNew() {
			ModelAndView mv = new ModelAndView("subject-management");
			mv.addObject("subject_addNew_clicked", true);
			mv.addObject("message", "the input form should be here");
			return mv;
		}
	 
	 @RequestMapping("/subjectSemester")
	 public ModelAndView subjectSemester() {
			ModelAndView mv = new ModelAndView("subject-management");
			mv.addObject("subject_semester_clicked", true);
			mv.addObject("message", "the input form should be here");
			return mv;
		}
	
	 @RequestMapping("subject/all")
	 public ModelAndView all() {
			ModelAndView mv = new ModelAndView("subject-management");
			mv.addObject("subject_all_requested", true);
			mv.addObject("all-subjects", subjectService.getallSubjectList());
			return mv;
		}
	 
	  @RequestMapping(value="subject/add",method = RequestMethod.POST)  
	    public ModelAndView save(@ModelAttribute("subjectModel") SubjectModel subject){  
			ModelAndView mv = new ModelAndView("subject-management");
			mv.addObject("subject_add_requested", true);
			mv.addObject("all-subjects", subjectService.addSubject(subject));
			return mv;
		}
	     
	 
	 @RequestMapping("subject/delete")
		public ModelAndView delete() {
			ModelAndView mv = new ModelAndView("subject-management");
			mv.addObject("subject_delete_requested", true);
			mv.addObject("message", "this is the main page");
			return mv;
		}
	
}
