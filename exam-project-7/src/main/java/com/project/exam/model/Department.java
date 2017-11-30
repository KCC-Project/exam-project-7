package com.project.exam.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="department")
public class Department {

	@Id
	private int depart_id;
	private String depart_name;
	private int status;
	
	 @OneToMany(mappedBy="programs")
	    private Set<Programs> programs;

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

	public Set<Programs> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Programs> programs) {
		this.programs = programs;
	}
	 
	
	
}
