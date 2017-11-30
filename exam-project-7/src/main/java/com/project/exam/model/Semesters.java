package com.project.exam.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="semesters")
public class Semesters {

	@Id
	private int semester_id;
	
	private int semseter_no;
	private int status;
	
	private Set<StudentsSemesters> studentSemester = new HashSet<StudentsSemesters>();
	
	@OneToMany(mappedBy="semesters")
	private List<SemestersInfos> semestersInfos;

	public int getSemester_id() {
		return semester_id;
	}

	public void setSemester_id(int semester_id) {
		this.semester_id = semester_id;
	}

	public int getSemseter_no() {
		return semseter_no;
	}

	public void setSemseter_no(int semseter_no) {
		this.semseter_no = semseter_no;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@OneToMany(mappedBy="semesters", cascade = CascadeType.ALL)
	public Set<StudentsSemesters> getStudentSemester() {
		return studentSemester;
	}

	public void setStudentSemester(Set<StudentsSemesters> studentSemester) {
		this.studentSemester = studentSemester;
	}

	public List<SemestersInfos> getSemestersInfos() {
		return semestersInfos;
	}

	public void setSemestersInfos(List<SemestersInfos> semestersInfos) {
		this.semestersInfos = semestersInfos;
	}
	
	
	
	   
}
