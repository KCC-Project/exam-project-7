package com.project.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="semesters_subject")
public class SemestersSubjects {
	@Id
	private int semester_subject_id;
	
	private Semesters semester;
	private Subjects subject;
	
	//additional fields
	private int status;

	public int getSemester_subject_id() {
		return semester_subject_id;
	}

	public void setSemester_subject_id(int semester_subject_id) {
		this.semester_subject_id = semester_subject_id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="semester_id")
	public Semesters getSemester() {
		return semester;
	}

	public void setSemester(Semesters semester) {
		this.semester = semester;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="subject_id")
	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
