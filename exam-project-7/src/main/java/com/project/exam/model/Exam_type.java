package com.project.exam.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="exam_types")
public class Exam_type {

	
	private int exam_type_id;
	
	private String type_name;
	
	private int status;
	
	
	private Set<Exam> exams;

	@Id
	public int getExam_type_id() {
		return exam_type_id;
	}

	public void setExam_type_id(int exam_type_id) {
		this.exam_type_id = exam_type_id;
	}

	@Column(nullable = false)
	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(mappedBy="exam_types")
	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	
}
