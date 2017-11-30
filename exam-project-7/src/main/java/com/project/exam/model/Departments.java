package com.project.exam.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "departments")
public class Departments {

	
	private int depart_id;
	private String depart_name;
	private int status;
	
	
	private Set<Programs> program;
	
	@Id
	public int getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public int getStatus() {
		return status; 
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@OneToMany(mappedBy="departments", cascade = CascadeType.ALL)
	public Set<Programs> getProgram() {
		return program;
	}
	public void setProgram(Set<Programs> program) {
		this.program = program;
	}

}
