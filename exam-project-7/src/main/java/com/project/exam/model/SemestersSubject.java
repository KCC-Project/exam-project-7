package com.project.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="semesters_subject")
public class SemestersSubject {
	
	
	private int semester_subject_id;
	
	@Column(nullable = false)
	private Semester semesters;
	
	@Column(nullable = false)
	private Subjects subjects;
	
	//additional fields
	private int status;

	@Id
	public int getSemester_subject_id() {
		return semester_subject_id;
	}

	public void setSemester_subject_id(int semester_subject_id) {
		this.semester_subject_id = semester_subject_id;
	}

	@ManyToOne
	@JoinColumn(name = "semester_id")
	public Semester getSemesters() {
		return semesters;
	}

	public void setSemesters(Semester semesters) {
		this.semesters = semesters;
	}

	@ManyToOne
	@JoinColumn(name = "subject_id")
	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	

}
