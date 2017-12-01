package com.project.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "students_semester")
public class StudentsSemester {
	
	private int student_semester_id;

	private Student students;

	private Semester semesters;

	// additional fields
	@Column(nullable = false)
	private int batch_year;
	
	private int status;

/*	
	@ManyToOne
	@JoinColumn(name = "semester_info_id")
	private SemestersInfos semesters_infos;
*/
	@Id
	public int getStudent_semester_id() {
		return student_semester_id;
	}

	public void setStudent_semester_id(int student_semester_id) {
		this.student_semester_id = student_semester_id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_id", nullable = false)
	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "semester_id", nullable = false)
	public Semester getSemesters() {
		return semesters;
	}

	public void setSemesters(Semester semesters) {
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
