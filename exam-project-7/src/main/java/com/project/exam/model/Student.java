package com.project.exam.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	private int gender;
	
	private Date date_of_birth;
	
	private String phone;
	private String address;
	
	private String image;
	
	private int current_semester;
	
	private int status;

	
	private Set<StudentsProgram> studentProgram = new HashSet<StudentsProgram>();
	
	
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

	@Column
	@Temporal(TemporalType.DATE)
	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@OneToMany(mappedBy = "students")
	public Set<StudentsProgram> getStudentProgram() {
		return studentProgram;
	}

	public void setStudentProgram(Set<StudentsProgram> studentProgram) {
		this.studentProgram = studentProgram;
	}

	@OneToMany(mappedBy = "students")
	public Set<StudentsExam> getStudentsExams() {
		return studentsExams;
	}

	public void setStudentsExams(Set<StudentsExam> studentsExams) {
		this.studentsExams = studentsExams;
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
	
	@Column(nullable = false)
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public int getCurrent_semester() {
		return current_semester;
	}

	public void setCurrent_semester(int current_semester) {
		this.current_semester = current_semester;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
				+ last_name + ", username=" + username + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", date_of_birth=" + date_of_birth + ", phone=" + phone + ", address=" + address + ", image="
				+ image + ", current_semester=" + current_semester + ", status=" + status + ", studentProgram="
				+ studentProgram + ", studentsExams=" + studentsExams + "]";
	}

	
	

	

}
