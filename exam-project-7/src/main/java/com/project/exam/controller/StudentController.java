package com.project.exam.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.exam.model.StudentsModel;
import com.project.exam.services.StudentService;

@Controller
@RequestMapping("/student-management")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/view")
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("student_view_clicked", true);
		mv.addObject("message", "the input form should be here");
		return mv;
	}

	@RequestMapping("/view/all")
	public ModelAndView all() {
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("student_all_requested", true);
		mv.addObject("message", "all records of student requested");
		return mv;
	}

	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public String addNew(@RequestParam("s_id") int s_id, @RequestParam("first_name") String first_name,
			@RequestParam("middle_name") String middle_name, @RequestParam("last_name") String last_name,
			@RequestParam("date_of_birth") String date_of_birth, @RequestParam("phone") int phone,
			@RequestParam("district") String district, @RequestParam("address") String address,
			@RequestParam("city") String city, @RequestParam("zipcode") String zipcode) {
		// ModelAndView mv = new ModelAndView("student-management");
		// mv.addObject("student_addNew_clicked", true);
		// mv.addObject("message", "the input form should be here");
		StudentsModel model = new StudentsModel(s_id, first_name, middle_name, last_name, date_of_birth, phone, address,
				city, district, zipcode);
		System.out.println(model.toString());
		//studentService.addStudent(model);
		return "sucess";
	}

	@RequestMapping("/studentSemester")
	public ModelAndView studentSemester() {
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("student_semester_clicked", true);
		mv.addObject("message", "the input form should be here");
		return mv;
	}

	@RequestMapping(value = "student/add", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("StudentModel") StudentsModel student) {
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("student_add_requested", true);
		mv.addObject("all-students", studentService.addStudent(student));
		return mv;
	}

	@RequestMapping("student/delete")
	public ModelAndView delete() {
		ModelAndView mv = new ModelAndView("student-management");
		mv.addObject("student_delete_requested", true);
		mv.addObject("message", "this is the main page");
		return mv;
	}

}
