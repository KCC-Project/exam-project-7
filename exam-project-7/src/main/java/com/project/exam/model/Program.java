package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
	private int total_credit;
	
	private int status;
	
	private Faculty faculty;
	
	private Set<StudentsProgram> studentsProgram = new HashSet<StudentsProgram>();
	
	private Set<Subjects> subject;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	@Column(nullable = false)
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

	public int getTotal_credit() {
		return total_credit;
	}

	public void setTotal_credit(int total_credit) {
		this.total_credit = total_credit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	@OneToMany(mappedBy = "program")
	public Set<StudentsProgram> getStudentsProgram() {
		return studentsProgram;
	}

	public void setStudentsProgram(Set<StudentsProgram> studentsProgram) {
		this.studentsProgram = studentsProgram;
	}

	@ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@OneToMany(mappedBy="program", cascade = CascadeType.ALL)
	public Set<Subjects> getSubject() {
		return subject;
	}

	public void setSubject(Set<Subjects> subject) {
		this.subject = subject;
	}

	

	
	 
	 
}
