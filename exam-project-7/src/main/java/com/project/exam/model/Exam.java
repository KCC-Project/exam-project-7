package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="exams")
public class Exam {

	
	private int exam_id;
	
	private Exam_type exam_types;
	
	private Subjects subjects;
	
	@Column
	@Temporal(TemporalType.DATE)
	private String exam_date;
	
	private String time_from;
	private String time_to;
	private int full_marks;
	private int pass_marks;
	private int status;
	
	private Set<StudentsExam> studentsExams = new HashSet<StudentsExam>();
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getExam_id() {
		return exam_id;
	}


	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	@Column(nullable = false)
	public String getExam_date() {
		return exam_date;
	}


	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}

	
	public String getTime_from() {
		return time_from;
	}


	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	
	public String getTime_to() {
		return time_to;
	}


	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}


	public int getFull_marks() {
		return full_marks;
	}


	public void setFull_marks(int full_marks) {
		this.full_marks = full_marks;
	}


	public int getPass_marks() {
		return pass_marks;
	}


	public void setPass_marks(int pass_marks) {
		this.pass_marks = pass_marks;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@OneToMany(mappedBy = "exams")
	public Set<StudentsExam> getStudentsExams() {
		return studentsExams;
	}


	public void setStudentsExams(Set<StudentsExam> studentsExams) {
		this.studentsExams = studentsExams;
	}

	@ManyToOne
    @JoinColumn(name = "exam_type_id", nullable = false)
	public Exam_type getExam_types() {
		return exam_types;
	}


	public void setExam_types(Exam_type exam_types) {
		this.exam_types = exam_types;
	}


	@ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
	public Subjects getSubjects() {
		return subjects;
	}


	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}


	@Override
	public String toString() {
		return "Exam [exam_id=" + exam_id + ", exam_types=" + exam_types + ", subjects=" + subjects + ", exam_date="
				+ exam_date + ", time_from=" + time_from + ", time_to=" + time_to + ", full_marks=" + full_marks
				+ ", pass_marks=" + pass_marks + ", status=" + status + ", studentsExams=" + studentsExams + "]";
	}


	
	
	
}
