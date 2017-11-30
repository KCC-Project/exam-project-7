package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subjects {

	@Id
	private int subject_id;
	private String subject_name;
	private String subject_code;
	private int theory_cr;
	private int tutorial_cr;
	private int internal_theory;
	private int internal_practical;
	private int final_theory;
	private int syllabus_file;
	private int status;
	
	private Set<SemestersSubjects> semesterSubjects = new HashSet<SemestersSubjects>();
}
