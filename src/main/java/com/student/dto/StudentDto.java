package com.student.dto;

public class StudentDto {
	private String studentId,email,name,password;

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String studentId, String email, String name, String password) {
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
