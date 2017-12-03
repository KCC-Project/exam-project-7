package com.project.exam.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "faculty")
public class Faculty {

	
	private int faculty_id;
	
	private String faculty_name;
	
	private int status;
	
	
	private Collection<Program> program= new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(int depart_id) {
		this.faculty_id = depart_id;
	}
	@Column(nullable = false)
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String depart_name) {
		this.faculty_name = depart_name;
	}
	public int getStatus() {
		return status; 
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@OneToMany(mappedBy="faculty",cascade = CascadeType.ALL)
	public Collection<Program> getProgram() {
		return program;
	}
	public void setProgram(Collection<Program> program) {
		this.program = program;
	}
	@Override
	public String toString() {
		return "Faculty [faculty_id=" + faculty_id + ", faculty_name=" + faculty_name + ", status=" + status + "]";
	}
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
