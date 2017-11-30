package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="exams")
public class Exams {

	
	private int exam_id;
	
	private String exam_date;
	private String time_from;
	private String time_to;
	private String full_marks;
	private String pass_marks;
	private int status;
	
	private Set<StudentsExams> studentsExams = new HashSet<StudentsExams>();
	
	
	private Exam_types exam_types;

	@Id
	public int getExam_id() {
		return exam_id;
	}


	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}


	public String getExam_date() {
		return exam_date;
	}


	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}


	public String getTime_from() {
		return time_from;
	}


	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}


	public String getTime_to() {
		return time_to;
	}


	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}


	public String getFull_marks() {
		return full_marks;
	}


	public void setFull_marks(String full_marks) {
		this.full_marks = full_marks;
	}


	public String getPass_marks() {
		return pass_marks;
	}


	public void setPass_marks(String pass_marks) {
		this.pass_marks = pass_marks;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@OneToMany(mappedBy = "exams")
	public Set<StudentsExams> getStudentsExams() {
		return studentsExams;
	}


	public void setStudentsExams(Set<StudentsExams> studentsExams) {
		this.studentsExams = studentsExams;
	}

	@ManyToOne
    @JoinColumn(name = "exam_type_id")
	public Exam_types getExam_types() {
		return exam_types;
	}


	public void setExam_types(Exam_types exam_types) {
		this.exam_types = exam_types;
	}


	
	
	
}
