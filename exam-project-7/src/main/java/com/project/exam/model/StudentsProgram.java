package com.project.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "students_program")
public class StudentsProgram {
	
	private int student_program_id;

	private Student students;

	private Program program;

	// additional fields
	@Column(nullable = false)
	private int batch_year;
	
	private String enroll_date;
	
	private int status;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStudent_program_id() {
		return student_program_id;
	}

	public void setStudent_program_id(int student_program_id) {
		this.student_program_id = student_program_id;
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
	@JoinColumn(name = "program_id", nullable = false)
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
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

	public String getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}

	@Override
	public String toString() {
		return "StudentsProgram [student_program_id=" + student_program_id + ", students=" + students + ", program="
				+ program + ", batch_year=" + batch_year + ", enroll_date=" + enroll_date + ", status=" + status + "]";
	}

	

	

}
