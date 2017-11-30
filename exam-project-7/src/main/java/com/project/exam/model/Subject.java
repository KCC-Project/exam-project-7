package com.project.exam.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="subject")
public class Subject {

	@Id
	private int subject_id;
	private String subject_name;
	private String subject_code;
	private int theory_cr;
	private int tutorial_cr;
	private int practical_cr;
	private int internal_theory;
	private int internal_practical;
	private int final_theory;
	private String syllabus_file;
	private int status;
	
	
	
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
	public int getPractical_cr() {
		return practical_cr;
	}
	public void setPractical_cr(int practical_cr) {
		this.practical_cr = practical_cr;
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
	public String getSyllabus_file() {
		return syllabus_file;
	}
	public void setSyllabus_file(String syllabus_file) {
		this.syllabus_file = syllabus_file;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SubjectModel [subject_id=" + subject_id + ", subject_name=" + subject_name + ", subject_code="
				+ subject_code + ", theory_cr=" + theory_cr + ", tutorial_cr=" + tutorial_cr + ", practical_cr="
				+ practical_cr + ", internal_theory=" + internal_theory + ", internal_practical=" + internal_practical
				+ ", final_theory=" + final_theory + ", syllabus_file=" + syllabus_file + ", status=" + status + "]";
	}
	public Subject(int subject_id, String subject_name, String subject_code, int theory_cr, int tutorial_cr,
			int practical_cr, int internal_theory, int internal_practical, int final_theory, String syllabus_file,
			int status) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.subject_code = subject_code;
		this.theory_cr = theory_cr;
		this.tutorial_cr = tutorial_cr;
		this.practical_cr = practical_cr;
		this.internal_theory = internal_theory;
		this.internal_practical = internal_practical;
		this.final_theory = final_theory;
		this.syllabus_file = syllabus_file;
		this.status = status;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
