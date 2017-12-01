package com.project.exam.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	
	private Set<Program> program;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getDepart_id() {
		return faculty_id;
	}
	public void setDepart_id(int depart_id) {
		this.faculty_id = depart_id;
	}
	@Column(nullable = false)
	public String getDepart_name() {
		return faculty_name;
	}
	public void setDepart_name(String depart_name) {
		this.faculty_name = depart_name;
	}
	public int getStatus() {
		return status; 
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@OneToMany(mappedBy="departments", cascade = CascadeType.ALL)
	public Set<Program> getProgram() {
		return program;
	}
	public void setProgram(Set<Program> program) {
		this.program = program;
	}

}