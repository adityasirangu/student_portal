package com.student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection ="students")
public class SolrStudent {

	@Id
	@Indexed(name="id",type="string")
	private String studentId;
	@Indexed(name="stpassword",type="string")
	private String password;
	public SolrStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SolrStudent(String studentId, String password) {
		super();
		this.studentId = studentId;
		this.password = password;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

