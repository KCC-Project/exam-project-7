package com.project.exam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "admins")
public class Admin {

		
		private int admin_id;
		
		private String admin_username;
		
		private String admin_password;
		private int status;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getAdmin_id() {
			return admin_id;
		}

		public void setAdmin_id(int admin_id) {
			this.admin_id = admin_id;
		}

		@Column(unique = true, nullable = false)
		public String getAdmin_username() {
			return admin_username;
		}

		public void setAdmin_username(String admin_username) {
			this.admin_username = admin_username;
		}

		@Column(nullable = false)
		public String getAdmin_password() {
			return admin_password;
		}

		public void setAdmin_password(String admin_password) {
			this.admin_password = admin_password;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
		
		
		
}


