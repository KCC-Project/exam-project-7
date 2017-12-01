/*package com.project.exam.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semesters_infos")
public class SemestersInfos {

	@Id
	private int semester_info_id;
	
	private String start_date;
	private String end_date;
	private int start_year;
	private int status;
	
	
	@OneToMany(mappedBy = "semestersInfos")
	private Set<StudentsSemesters> studentsSemesters;
	
	@ManyToOne
	@JoinColumn(name = "semester_id")
	private Semesters semesters;

	public int getSemester_info_id() {
		return semester_info_id;
	}

	public void setSemester_info_id(int semester_info_id) {
		this.semester_info_id = semester_info_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getStart_year() {
		return start_year;
	}

	public void setStart_year(int start_year) {
		this.start_year = start_year;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<StudentsSemesters> getStudentsSemesters() {
		return studentsSemesters;
	}

	public void setStudentsSemesters(Set<StudentsSemesters> studentsSemesters) {
		this.studentsSemesters = studentsSemesters;
	}

	public Semesters getSemesters() {
		return semesters;
	}

	public void setSemesters(Semesters semesters) {
		this.semesters = semesters;
	}

	

	
	
	
	
	
}
*/