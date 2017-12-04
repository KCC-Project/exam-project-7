package com.project.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Admin;
import com.project.exam.model.Exam;

@Repository("examDao")
public class ExamDAOImpl implements ExamDAO{
	private Connection conn;
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public List<Exam> getExamList() {
		List<Exam> listAdmin = new ArrayList<Exam>();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from exams";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Exam model = new Exam();
				model.setExam_id(rs.getInt("exam_id"));
				model.setExam_date(rs.getString("exam_date"));
				model.setFull_marks(rs.getInt("full_marks"));
				model.setPass_marks(rs.getInt("pass_marks"));
				model.setStatus(rs.getInt("status"));
				model.setTime_from(rs.getString("time_from"));
				model.setTime_to(rs.getString("time_to"));
				model.setExam_type_id(rs.getInt("exam_type_id"));
				model.setSubject_id(rs.getInt("subject_id"));
				listAdmin.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listAdmin;
	}

	@Override
	public Exam addExam(Exam exam) {
		boolean status = false;

		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "insert into exams(exam_date,full_marks,pass_marks,status,time_from,time_to,exam_type_id,subject_id) values(?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			int col = 1;
	pst.setString(col++, exam.getExam_date());
	pst.setInt(col++, exam.getFull_marks());
	pst.setInt(col++, exam.getPass_marks());
	pst.setInt(col++, exam.getStatus());
	pst.setString(col++, exam.getTime_from());
	pst.setString(col++, exam.getTime_to());
	pst.setInt(col++, exam.getExam_type_id());
	pst.setInt(col++, exam.getSubject_id());
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
			return exam;
		}
		return new Exam();
	}

	@Override
	public Exam getExam(int s_Id) {
		Exam model = new Exam();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from exams where exam_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				model.setExam_id(rs.getInt("exam_id"));
				model.setExam_date(rs.getString("exam_date"));
				model.setFull_marks(rs.getInt("full_marks"));
				model.setPass_marks(rs.getInt("pass_marks"));
				model.setStatus(rs.getInt("status"));
				model.setTime_from(rs.getString("time_from"));
				model.setTime_to(rs.getString("time_to"));
				model.setExam_type_id(rs.getInt("exam_type_id"));
				model.setSubject_id(rs.getInt("subject_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	@Override
	public Exam updateExam(Exam exam) {
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "update exams set exam_date=?,full_marks=?,pass_marks=?,status=?,time_from=?,time_to=?,exam_type_id=?,subject_id=? where exam_id=?";
			pst = conn.prepareStatement(sql);
			int col = 1;
			pst.setString(col++, exam.getExam_date());
			pst.setInt(col++, exam.getFull_marks());
			pst.setInt(col++, exam.getPass_marks());
			pst.setInt(col++, exam.getStatus());
			pst.setString(col++, exam.getTime_from());
			pst.setString(col++, exam.getTime_to());
			pst.setInt(col++, exam.getExam_type_id());
			pst.setInt(col++, exam.getSubject_id());
			pst.setInt(col++, exam.getExam_id());
			int count = pst.executeUpdate();
			if (count > 0) {

				return exam;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Exam();
	}

	@Override
	public int deleteExam(int s_Id) {
		int result = 0;
		// System.out.println("deleting id form ecaminfoModel="+id);
		try {
			Connection connection = DatabaseConnection.connectToDatabase();
			sql = "delete from exams where exam_id =?";
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
