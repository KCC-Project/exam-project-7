package com.project.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.exam.model.Admin;
import com.project.exam.model.StudentsExam;

@Repository("studentExamDao")
public class StudentsExamDAOImpl implements StudentsExamDAO {
	private Connection conn;
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public List<StudentsExam> getstudentsExamList() {
		List<StudentsExam> listStudentsExam = new ArrayList<StudentsExam>();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from students_exams";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				StudentsExam model = new StudentsExam();
				model.setStudents_exams_id(rs.getInt("students_exams_id"));
				model.setAttendance_status(rs.getInt("attendance_status"));
				model.setGrade(rs.getString("grade"));
				model.setObtained_marks(rs.getInt("obtained_marks"));
				model.setStatus(rs.getInt("status"));
				model.setExam_id(rs.getInt("exam_id"));
				model.setS_id(rs.getInt("s_id"));
				listStudentsExam.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listStudentsExam;
	}

	@Override
	public StudentsExam addstudentsExam(StudentsExam studentsExam) {
		boolean status = false;

		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "insert into students_exams(attendance_status,grade,obtained_marks,status,exam_id,s_id) values(?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			int col = 1;
		pst.setInt(col++, studentsExam.getAttendance_status());
		pst.setString(col++, studentsExam.getGrade());
		pst.setInt(col++, studentsExam.getObtained_marks());
		pst.setInt(col++, studentsExam.getStatus());
		pst.setInt(col++, studentsExam.getExam_id());
		pst.setInt(col++, studentsExam.getS_id());
			int count = pst.executeUpdate();
			if (count > 0) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println("Error from saving admin=" + e);
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
			return studentsExam;
		}
		return new StudentsExam();
	}

	@Override
	public StudentsExam getstudentsExam(int s_Id) {
		StudentsExam model = new StudentsExam();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from students_exams where students_exams_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				model.setStudents_exams_id(rs.getInt("students_exams_id"));
				model.setAttendance_status(rs.getInt("attendance_status"));
				model.setGrade(rs.getString("grade"));
				model.setObtained_marks(rs.getInt("obtained_marks"));
				model.setStatus(rs.getInt("status"));
				model.setExam_id(rs.getInt("exam_id"));
				model.setS_id(rs.getInt("s_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	@Override
	public StudentsExam updatestudentsExam(StudentsExam studentsExam) {
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "update students_exams set attendance_status=?,grade=?,obtained_marks=?,status=?,exam_id=?,s_id=? where students_exams_id=?";
			pst = conn.prepareStatement(sql);
			int col = 1;
			pst.setInt(col++, studentsExam.getAttendance_status());
			pst.setString(col++, studentsExam.getGrade());
			pst.setInt(col++, studentsExam.getObtained_marks());
			pst.setInt(col++, studentsExam.getStatus());
			pst.setInt(col++, studentsExam.getExam_id());
			pst.setInt(col++, studentsExam.getS_id());
			pst.setInt(col++, studentsExam.getStudents_exams_id());
			int count = pst.executeUpdate();
			if (count > 0) {

				return studentsExam;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new StudentsExam();	}

	@Override
	public int deletestudentsExam(int s_Id) {
		int result = 0;
		// System.out.println("deleting id form ecaminfoModel="+id);
		try {
			Connection connection = DatabaseConnection.connectToDatabase();
			sql = "delete from students_exams where students_exams_id =?";
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
	
}
