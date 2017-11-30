package com.project.exam.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="semester_subject")
public class SemestersSubjects {
	private Semesters semester;
	private Subjects subject;
	
	//additional fields
	private int status;
	

}
