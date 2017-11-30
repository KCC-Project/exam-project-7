package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subjects {

	
	private int subject_id;
	
	private String subject_name;
	private String subject_code;
	private int theory_cr;
	private int tutorial_cr;
	private int internal_theory;
	private int internal_practical;
	private int final_theory;
	private int syllabus_file;
	private int status;

	
	private Set<SemestersSubjects> semesterSubjects = new HashSet<SemestersSubjects>();

	@Id
	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public int getTheory_cr() {
		return theory_cr;
	}

	public void setTheory_cr(int theory_cr) {
		this.theory_cr = theory_cr;
	}

	public int getTutorial_cr() {
		return tutorial_cr;
	}

	public void setTutorial_cr(int tutorial_cr) {
		this.tutorial_cr = tutorial_cr;
	}

	public int getInternal_theory() {
		return internal_theory;
	}

	public void setInternal_theory(int internal_theory) {
		this.internal_theory = internal_theory;
	}

	public int getInternal_practical() {
		return internal_practical;
	}

	public void setInternal_practical(int internal_practical) {
		this.internal_practical = internal_practical;
	}

	public int getFinal_theory() {
		return final_theory;
	}

	public void setFinal_theory(int final_theory) {
		this.final_theory = final_theory;
	}

	public int getSyllabus_file() {
		return syllabus_file;
	}

	public void setSyllabus_file(int syllabus_file) {
		this.syllabus_file = syllabus_file;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "subjects")
	public Set<SemestersSubjects> getSemesterSubjects() {
		return semesterSubjects;
	}

	public void setSemesterSubjects(Set<SemestersSubjects> semesterSubjects) {
		this.semesterSubjects = semesterSubjects;
	}

}
