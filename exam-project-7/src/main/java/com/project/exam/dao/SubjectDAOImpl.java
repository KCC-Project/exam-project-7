package com.project.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.project.exam.model.Student;
import com.project.exam.model.Subjects;

@Repository("subjectDao")
public class SubjectDAOImpl implements SubjectDAO {
	private Connection conn;
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public List<Subjects> getallSubjectList() {
		List<Subjects> listSubjects = new ArrayList<Subjects>();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from subjects";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Subjects model = new Subjects();
				model.setSubject_id(rs.getInt("subject_id"));
				model.setFinal_theory(rs.getInt("final_theory"));
				model.setInternal_practical(rs.getInt("internal_practical"));
				model.setInternal_theory(rs.getInt("internal_theory"));
				model.setSemester_no(rs.getInt("semester_no"));
				model.setStatus(rs.getInt("status"));
				model.setSubject_code(rs.getString("subject_code"));
				model.setSubject_name(rs.getString("subject_name"));
				model.setSyllabus_file(rs.getString("syllabus_file"));
				model.setTheory_cr(rs.getInt("theory_cr"));
				model.setTutorial_cr(rs.getInt("tutorial_cr"));
				model.setProgram_id(rs.getInt("program_id"));
				listSubjects.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSubjects;
	}

	@Override
	public Subjects addStudent(Subjects subject) {
		boolean status = false;

		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "insert into subjects(final_theory,internal_practical,internal_theory,semester_no,status,subject_code,subject_name,"
					+ "syllabus_file,theory_cr,tutorial_cr,program_id) values(?,?,?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			int col = 1;

			pst.setInt(col++, subject.getFinal_theory());
			pst.setInt(col++, subject.getInternal_practical());
			pst.setInt(col++, subject.getInternal_theory());
			pst.setInt(col++, subject.getSemester_no());
			pst.setInt(col++, subject.getStatus());
			pst.setString(col++, subject.getSubject_code());
			pst.setString(col++, subject.getSubject_name());
			pst.setString(col++, subject.getSyllabus_file());
			pst.setInt(col++, subject.getTheory_cr());
			pst.setInt(col++, subject.getTutorial_cr());
			pst.setInt(col++, subject.getProgram_id());

			int count = pst.executeUpdate();
			if (count > 0) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println("Error from saving studentsProgram=" + e);
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
			return subject;
		}
		return new Subjects();
	}

	@Override
	public Subjects getSubject(int s_Id) {
		Subjects model = new Subjects();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from subjects where subject_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				model.setSubject_id(rs.getInt("subject_id"));
				model.setFinal_theory(rs.getInt("final_theory"));
				model.setInternal_practical(rs.getInt("internal_practical"));
				model.setInternal_theory(rs.getInt("internal_theory"));
				model.setSemester_no(rs.getInt("semester_no"));
				model.setStatus(rs.getInt("status"));
				model.setSubject_code(rs.getString("subject_code"));
				model.setSubject_name(rs.getString("subject_name"));
				model.setSyllabus_file(rs.getString("syllabus_file"));
				model.setTheory_cr(rs.getInt("theory_cr"));
				model.setTutorial_cr(rs.getInt("tutorial_cr"));
				model.setProgram_id(rs.getInt("program_id"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	@Override
	public Subjects updateSubject(Subjects subject) {

		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "update subjects set final_theory=?,internal_practical=?,internal_theory=?,semester_no=?,status=?,subject_code=?,subject_name=?,syllabus_file=?,theory_cr=?,tutorial_cr=?,program_id=? where subject_id=?";
			pst = conn.prepareStatement(sql);
			int col = 1;
			pst.setInt(col++, subject.getFinal_theory());
			pst.setInt(col++, subject.getInternal_practical());
			pst.setInt(col++, subject.getInternal_theory());
			pst.setInt(col++, subject.getSemester_no());
			pst.setInt(col++, subject.getStatus());
			pst.setString(col++, subject.getSubject_code());
			pst.setString(col++, subject.getSubject_name());
			pst.setString(col++, subject.getSyllabus_file());
			pst.setInt(col++, subject.getTheory_cr());
			pst.setInt(col++, subject.getTutorial_cr());
			pst.setInt(col++, subject.getProgram_id());
			pst.setInt(col++, subject.getSubject_id());
			int count = pst.executeUpdate();
			if (count > 0) {

				return subject;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Subjects();
	}

	@Override
	public int deleteSubject(int s_Id) {
		int result = 0;
		// System.out.println("deleting id form ecaminfoModel="+id);
		try {
			Connection connection = DatabaseConnection.connectToDatabase();
			sql = "delete from subjects where subject_id =?";
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
	public List searchSubject(String searchPara) {
		
		List listOfResult = new ArrayList<>();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "SELECT * FROM subjects WHERE subject_name like '" + searchPara + "%'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				Subjects s = new Subjects();
				String subjectName = null;
				subjectName = rs.getString("subject_name") + " " + rs.getString("subject_code");

				map.put("id", rs.getInt("subject_id"));
				map.put("name", subjectName);
				listOfResult.add(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfResult;
	}

	@Override
	public List<Subjects> getSubjectByParameters(Object[] obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
