package com.project.exam.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="semester")
public class Semester {

	@Id
	private int semester_id;
	
	private int semseter_no;
	private int status;
	
	
	
}
