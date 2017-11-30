package com.project.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students_semester")
public class StudentsSemester {
	private int student_semester_id;
	private Students students;
	private Semesters semester;
	
	// additional fields
	private int status;
	private int batch_year;
	
	
	public int getStudent_semester_id() {
		return student_semester_id;
	}
	public void setStudent_semester_id(int student_semester_id) {
		this.student_semester_id = student_semester_id;
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
	@JoinColumn(name="sem_id")
	public Semesters getSemester() {
		return semester;
	}
	
	public void setSemester(Semesters semester) {
		this.semester = semester;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBatch_year() {
		return batch_year;
	}
	public void setBatch_year(int batch_year) {
		this.batch_year = batch_year;
	}
	
	
	
	
	

}
