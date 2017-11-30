package com.project.exam.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "students_semester")
public class StudentsSemesters {
	@Id
	private int student_semester_id;

	@ManyToOne
	@JoinColumn(name = "s_id")
	private Students students;

	@ManyToOne
	@JoinColumn(name = "semester_id")
	private Semesters semesters;

	// additional fields
	private int status;
	private int batch_year;

/*	
	@ManyToOne
	@JoinColumn(name = "semester_info_id")
	private SemestersInfos semesters_infos;
*/
	
	public int getStudent_semester_id() {
		return student_semester_id;
	}

	public void setStudent_semester_id(int student_semester_id) {
		this.student_semester_id = student_semester_id;
	}

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Semesters getSemesters() {
		return semesters;
	}

	public void setSemesters(Semesters semesters) {
		this.semesters = semesters;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBatch_year() {
		return batch_year;
	}

	public void setBatch_year(int batch_year) {
		this.batch_year = batch_year;
	}


	

}
