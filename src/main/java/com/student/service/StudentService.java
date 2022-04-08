package com.student.service;

import com.student.dto.StudentDto;
import com.student.model.Student;

public interface StudentService {
	
	public Student save(StudentDto studnetDto);
	public Student getUser(String id);
	public Boolean Auth(String id, String password);

}
