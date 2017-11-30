package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "students")
public class Students {

	
	private int s_id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String date_of_birth;
	private int phone;
	private String address;
	private String city;
	private String district;
	private String zipcode;

	
	private Set<StudentsSemesters> studentSemesters = new HashSet<StudentsSemesters>();
	
	
	private Set<StudentsExams> studentsExams = new HashSet<StudentsExams>();

	@Id
	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@OneToMany(mappedBy = "students")
	public Set<StudentsSemesters> getStudentSemesters() {
		return studentSemesters;
	}

	public void setStudentSemesters(Set<StudentsSemesters> studentSemesters) {
		this.studentSemesters = studentSemesters;
	}

	@OneToMany(mappedBy = "students")
	public Set<StudentsExams> getStudentsExams() {
		return studentsExams;
	}

	public void setStudentsExams(Set<StudentsExams> studentsExams) {
		this.studentsExams = studentsExams;
	}

	
	

}
