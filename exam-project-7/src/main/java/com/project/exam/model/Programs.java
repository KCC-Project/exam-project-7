package com.project.exam.model;

import java.util.Set;

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

public class Programs {

	@Id
	private int program_id;
	
	private String program_name;
	private int program_years;
	private int program_semesters;
	private int total_credit;
	private String program_update_date;
	int status;
	

	 @ManyToOne
	    @JoinColumn(name="depart_id", nullable=false)
	    private Department department;

	 @OneToMany(mappedBy="semester")
	    private Set<Semester> semester;

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


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
	
	


	public Set<Semester> getSemester() {
		return semester;
	}


	public void setSemester(Set<Semester> semester) {
		this.semester = semester;
	}


	public Programs() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Programs [program_id=" + program_id + ", program_name=" + program_name + ", program_years="
				+ program_years + ", program_semesters=" + program_semesters + ", total_credit=" + total_credit
				+ ", program_update_date=" + program_update_date + ", status=" + status + ", department=" + department
				+ ", semester=" + semester + "]";
	}


	
	 
	 
	 
	 
}
