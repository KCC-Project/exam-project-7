package com.project.exam.model;

import java.util.HashSet;
import java.util.List;
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
@Table(name="semesters")
public class Semesters {

	
	private int semester_id;
	
	private int semester_no;
	private int status;
	
	
	private Set<StudentsSemesters> studentsSemester = new HashSet<StudentsSemesters>();
	
	
	//private Set<SemestersInfos> semestersInfos;
	
	
	private Programs programs;

	@Id
	public int getSemester_id() {
		return semester_id;
	}

	public void setSemester_id(int semester_id) {
		this.semester_id = semester_id;
	}

	public int getSemester_no() {
		return semester_no;
	}

	public void setSemester_no(int semester_no) {
		this.semester_no = semester_no;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "semesters")
	public Set<StudentsSemesters> getStudentsSemester() {
		return studentsSemester;
	}

	public void setStudentsSemester(Set<StudentsSemesters> studentsSemester) {
		this.studentsSemester = studentsSemester;
	}

	@ManyToOne
    @JoinColumn(name = "program_id")
	public Programs getPrograms() {
		return programs;
	}

	public void setPrograms(Programs programs) {
		this.programs = programs;
	}
/*
	@OneToMany(mappedBy = "semesters")
	public Set<SemestersInfos> getSemestersInfos() {
		return semestersInfos;
	}

	public void setSemestersInfos(Set<SemestersInfos> semestersInfos) {
		this.semestersInfos = semestersInfos;
	}

	*/
	
	
	   
}
