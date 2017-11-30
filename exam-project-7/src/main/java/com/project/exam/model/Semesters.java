package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="semester")
public class Semesters {

	@Id
	private int semester_id;
	
	private int semseter_no;
	private int status;
	
	private Set<StudentsSemester> studentSemester = new HashSet<StudentsSemester>();
	
	
	    public Set<StudentsSemester> getStudentSemester() {
	        return studentSemester;
	    }
}
