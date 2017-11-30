package com.project.exam.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="exam_type")
public class Exam_types {

	@Id
	private int exam_type_id;
	private String type_name;
	private int status;
	
	@OneToMany(mappedBy="exams")
	private Set<Exams> exams;

	public int getExam_type_id() {
		return exam_type_id;
	}

	public void setExam_type_id(int exam_type_id) {
		this.exam_type_id = exam_type_id;
	}

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

	public Set<Exams> getExams() {
		return exams;
	}

	public void setExams(Set<Exams> exams) {
		this.exams = exams;
	}
	
	
	
	
}
