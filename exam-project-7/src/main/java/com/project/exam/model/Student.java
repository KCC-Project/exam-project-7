package com.project.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "students")
public class Student {

	
	private int s_id;
	
	private String first_name;
	
	private String middle_name;
	
	private String last_name;
	
	private String username;
	
	private String password;
	
	private String email;
	
	
	
	private String date_of_birth;
	private int phone;
	private String address;
	
	private String registeredDate;
	
	private int status;

	
	private Set<StudentsSemester> studentSemesters = new HashSet<StudentsSemester>();
	
	
	private Set<StudentsExam> studentsExams = new HashSet<StudentsExam>();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	@Column(nullable = false)
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

	@Column(nullable = false)
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


	@OneToMany(mappedBy = "students")
	public Set<StudentsSemester> getStudentSemesters() {
		return studentSemesters;
	}

	public void setStudentSemesters(Set<StudentsSemester> studentSemesters) {
		this.studentSemesters = studentSemesters;
	}

	@OneToMany(mappedBy = "students")
	public Set<StudentsExam> getStudentsExams() {
		return studentsExams;
	}

	public void setStudentsExams(Set<StudentsExam> studentsExams) {
		this.studentsExams = studentsExams;
	}

	 
	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(unique = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
				+ last_name + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", date_of_birth=" + date_of_birth + ", phone=" + phone + ", address=" + address + ", registeredDate="
				+ registeredDate + ", status=" + status + ", studentSemesters=" + studentSemesters + ", studentsExams="
				+ studentsExams + "]";
	}

	

	

	
	

}
