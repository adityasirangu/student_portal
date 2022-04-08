package com.student.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="student", uniqueConstraints=@UniqueConstraint(columnNames = "email"))
public class Student implements Serializable {
	@Id
	@Column(name="student_id")
	private String studentId;

	private String email;

	private String name;

	private String password;
	
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String email, String name, String password) {
		super();
		this.studentId = studentId;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
