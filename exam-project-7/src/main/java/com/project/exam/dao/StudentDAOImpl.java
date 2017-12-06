package com.project.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Student;
import com.project.exam.model.Subjects;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {
	private Connection conn;
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public List<Student> getStudentList() {
		List<Student> listStudent = new ArrayList<Student>();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from students";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student model = new Student();
				model.setS_id(rs.getInt("s_id"));
				model.setAddress(rs.getString("address"));
				model.setCurrent_semester(rs.getInt("current_semester"));
				model.setDate_of_birth(rs.getString("date_of_birth"));
				model.setEmail(rs.getString("email"));
				model.setFirst_name(rs.getString("first_name"));
				model.setGender(rs.getInt("gender"));
				model.setImage(rs.getString("image"));
				model.setLast_name(rs.getString("last_name"));
				model.setMiddle_name(rs.getString("middle_name"));
				model.setPassword(rs.getString("password"));
				model.setPhone(rs.getString("phone"));
				model.setStatus(rs.getInt("status"));
				model.setUsername(rs.getString("username"));
				listStudent.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listStudent;
	}

	@Override
	public Student addStudent(Student student) {
		boolean status = false;

		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "insert into students(address,current_semester,date_of_birth,email,first_name,gender,image,last_name,middle_name,password,phone,status,username) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			int col = 1;
			pst.setString(col++, student.getAddress());
			pst.setInt(col++, student.getCurrent_semester());
			pst.setString(col++, student.getDate_of_birth());
			pst.setString(col++, student.getEmail());
			pst.setString(col++, student.getFirst_name());
			pst.setInt(col++, student.getGender());
			pst.setString(col++, student.getImage());
			pst.setString(col++, student.getLast_name());
			pst.setString(col++, student.getMiddle_name());
			pst.setString(col++, student.getPassword());
			pst.setString(col++, student.getPhone());
			pst.setInt(col++, student.getStatus());
			pst.setString(col++, student.getUsername());
			
			
			

			int count = pst.executeUpdate();
			if (count > 0) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println("Error from saving students=" + e);
		} finally {
			try {
				pst.close();
				rs.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		if (status == true) {
			return student;
		}
		return new Student();
	}

	@Override
	public List<Student> getStudent(int s_Id) {
		List<Student> listStudent= new ArrayList<>();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from students where s_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student model = new Student();
				model.setS_id(rs.getInt("s_id"));
				model.setAddress(rs.getString("address"));
				model.setCurrent_semester(rs.getInt("current_semester"));
				model.setDate_of_birth(rs.getString("date_of_birth"));
				model.setEmail(rs.getString("email"));
				model.setFirst_name(rs.getString("first_name"));
				model.setGender(rs.getInt("gender"));
				model.setImage(rs.getString("image"));
				model.setLast_name(rs.getString("last_name"));
				model.setMiddle_name(rs.getString("middle_name"));
				model.setPassword(rs.getString("password"));
				model.setPhone(rs.getString("phone"));
				model.setStatus(rs.getInt("status"));
				model.setUsername(rs.getString("username"));
				listStudent.add(model);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listStudent;
	}

	@Override
	public Student updateStudent(Student student) {
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "update students set address=?,current_semester=?,date_of_birth=?,email=?,first_name=?,gender=?,image=?,last_name=?,middle_name=?,password=?,phone=?,status=?,username=? where s_id=?";
			pst = conn.prepareStatement(sql);
			int col = 1;
			pst.setString(col++, student.getAddress());
			pst.setInt(col++, student.getCurrent_semester());
			pst.setString(col++, student.getDate_of_birth());
			pst.setString(col++, student.getEmail());
			pst.setString(col++, student.getFirst_name());
			pst.setInt(col++, student.getGender());
			pst.setString(col++, student.getImage());
			pst.setString(col++, student.getLast_name());
			pst.setString(col++, student.getMiddle_name());
			pst.setString(col++, student.getPassword());
			pst.setString(col++, student.getPhone());
			pst.setInt(col++, student.getStatus());
			pst.setString(col++, student.getUsername());
			pst.setInt(col++, student.getS_id());
			int count = pst.executeUpdate();
			if (count > 0) {

				return student;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Student();
	}

	@Override
	public int deleteStudent(int s_Id) {
		int result = 0;
		// System.out.println("deleting id form ecaminfoModel="+id);
		try {
			Connection connection = DatabaseConnection.connectToDatabase();
			sql = "delete from students where s_id =?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, s_Id);
			result = pst.executeUpdate();
		} catch (Exception e) {
			// System.out.println("Error in deleting examInfo model="+e.getMessage());
		} finally {
			try {
				pst.close();
				rs.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	@Override
	public List searchStudent(String searchPara) {
		
		List listOfReslut = new ArrayList<>();
		//System.out.println("search ="+searchPara);
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "SELECT * FROM students WHERE MATCH(first_name, middle_name, last_name) AGAINST('"+ searchPara + "' IN NATURAL LANGUAGE MODE)";
			pst=conn.prepareStatement(sql);
			rs = pst.executeQuery();
		//System.out.println("here");
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				Student s = new Student();
				String name = null;
				System.out.println("m name = " +rs.getString("middle_name"));
				try {
					if (rs.getString("middle_name")== null) {
						name = rs.getString("first_name") + " " +  rs.getString("last_name");
					} else {
						name = rs.getString("first_name") + " " + rs.getString("middle_name") + " " +rs.getString("last_name");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				map.put("id", rs.getInt("s_id"));
				map.put("name", name);
				map.put("image",rs.getString("image"));
				listOfReslut.add(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfReslut;
	}

}
