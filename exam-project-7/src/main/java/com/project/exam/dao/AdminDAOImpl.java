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
import org.springframework.transaction.annotation.Transactional;

import com.project.exam.model.Admin;
import com.project.exam.model.Student;

@Repository("adminDao")
public class AdminDAOImpl implements AdminDAO {
	private Connection conn;
	private String sql;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public List<Admin> getAdminList() {
		List<Admin> listAdmin = new ArrayList<Admin>();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from admins";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Admin model = new Admin();
				model.setAdmin_id(rs.getInt("admin_id"));
				model.setAdmin_password(rs.getString("admin_password"));
				model.setAdmin_username(rs.getString("admin_username"));
				model.setStatus(rs.getInt("status"));
				listAdmin.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listAdmin;
	}

	@Override
	public Admin addAdmin(Admin admin) {
		boolean status = false;

		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "insert into admins(admin_password,admin_username,status) values(?,?,?)";
			pst = conn.prepareStatement(sql);
			int col = 1;
			pst.setString(col++, admin.getAdmin_password());
			pst.setString(col++, admin.getAdmin_username());
			pst.setInt(col++, admin.getStatus());
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
			return admin;
		}
		return new Admin();
	}

	@Override
	public Admin getAdmin(int s_Id) {
		Admin model = new Admin();
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "Select * from admins where admin_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, s_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				model.setAdmin_id(rs.getInt("admin_id"));
				model.setAdmin_password(rs.getString("admin_password"));
				model.setAdmin_username(rs.getString("admin_username"));
				model.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		try {
			conn = DatabaseConnection.connectToDatabase();
			sql = "update admins set admin_password=?,admin_username=?,status=? where admin_id=?";
			pst = conn.prepareStatement(sql);
			int col = 1;
			pst.setString(col++, admin.getAdmin_password());
			pst.setString(col++, admin.getAdmin_username());
			pst.setInt(col++, admin.getStatus());
			pst.setInt(col++, admin.getAdmin_id());
			int count = pst.executeUpdate();
			if (count > 0) {

				return admin;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Admin();

	}

	@Override
	public int deleteAdmin(int s_Id) {
		int result = 0;
		// System.out.println("deleting id form ecaminfoModel="+id);
		try {
			Connection connection = DatabaseConnection.connectToDatabase();
			sql = "delete from admins where admin_id =?";
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
