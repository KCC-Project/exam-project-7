package com.project.exam.services;

import java.util.List;

import com.project.exam.model.Admin;

public interface AdminService {
	public List<Admin> getAdminList();
	public Admin addAdmin(Admin admin);
	public Admin getAdmin(int s_Id);
	public Admin updateAdmin(Admin admin);
	public int deleteAdmin(int s_Id);
}
