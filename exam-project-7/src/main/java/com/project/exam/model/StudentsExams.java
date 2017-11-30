package com.project.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students_exams")
public class StudentsExams {
	
	@Id
	private int students_exams_id;
	
	private Students students;
	private Exams exams;
	
	// additional field
	private int attendance_status;
	private int obtained_marks;
	private String grade;
	private int status;
	
	public int getStudents_exams_id() {
		return students_exams_id;
	}
	public void setStudents_exams_id(int students_exams_id) {
		this.students_exams_id = students_exams_id;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="s_id")
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="exam_id")
	public Exams getExams() {
		return exams;
	}
	public void setExams(Exams exams) {
		this.exams = exams;
	}
	public int getAttendance_status() {
		return attendance_status;
	}
	public void setAttendance_status(int attendance_status) {
		this.attendance_status = attendance_status;
	}
	public int getObtained_marks() {
		return obtained_marks;
	}
	public void setObtained_marks(int obtained_marks) {
		this.obtained_marks = obtained_marks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}