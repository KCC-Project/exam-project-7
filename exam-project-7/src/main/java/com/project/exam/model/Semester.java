/* package com.project.exam.model;

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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="semesters")
public class Semester {

	private int semester_id;
	
	private int semester_no;
	
	private int status;
	
	
	private Set<StudentsProgram> studentsSemester = new HashSet<StudentsProgram>();
	
	
	private Program programs;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSemester_id() {
		return semester_id;
	}

	public void setSemester_id(int semester_id) {
		this.semester_id = semester_id;
	}

	@Column(nullable = false)
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
	public Set<StudentsProgram> getStudentsSemester() {
		return studentsSemester;
	}

	public void setStudentsSemester(Set<StudentsProgram> studentsSemester) {
		this.studentsSemester = studentsSemester;
	}

	@ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
	public Program getPrograms() {
		return programs;
	}

	public void setPrograms(Program programs) {
		this.programs = programs;
	}
	
	   
}
*/