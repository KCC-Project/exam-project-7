package com.project.exam.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="programs")

public class Program {

	
	private int program_id;
	
	private String program_name;
	private int program_years;
	private int program_semesters;
	private int total_credit;
	private String program_update_date;
	private int status;
	
	
	private Department departments;
	
	private Set<Semester> semesters;

	@Id
	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public int getProgram_years() {
		return program_years;
	}

	public void setProgram_years(int program_years) {
		this.program_years = program_years;
	}

	public int getProgram_semesters() {
		return program_semesters;
	}

	public void setProgram_semesters(int program_semesters) {
		this.program_semesters = program_semesters;
	}

	public int getTotal_credit() {
		return total_credit;
	}

	public void setTotal_credit(int total_credit) {
		this.total_credit = total_credit;
	}

	public String getProgram_update_date() {
		return program_update_date;
	}

	public void setProgram_update_date(String program_update_date) {
		this.program_update_date = program_update_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ManyToOne
    @JoinColumn(name = "depart_id")
	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}

	@OneToMany(mappedBy="programs", cascade = CascadeType.ALL)
	public Set<Semester> getSemester() {
		return semesters;
	}

	public void setSemester(Set<Semester> semesters) {
		this.semesters = semesters;
	}

	
	
/*
	 @ManyToOne
	    @JoinColumn(name="depart_id", nullable=false)
	    private Department department;

	 @OneToMany(mappedBy="semester")
	    private Set<Semester> semester;
*/
	
	
	 
	 
}
