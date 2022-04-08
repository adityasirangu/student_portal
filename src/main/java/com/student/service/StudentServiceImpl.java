package com.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.student.dto.StudentDto;
import com.student.model.Student;
import com.student.repository.StudnetRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudnetRepository repository;

	@Override
	public Student save(StudentDto studnetDto) {
		Student student=new Student(studnetDto.getStudentId(), studnetDto.getEmail(), studnetDto.getName(), studnetDto.getPassword());
		return repository.save(student);
	}

	@Override
	 @Cacheable(value = "students",key = "#id")
	public Student getUser(String id) {
		Optional<Student> student = repository.findById(id);
		if (student != null) {
			return student.get();
		}
		return null;
	}

	@Override
	public Boolean Auth(String id, String password) {
		Optional<Student> student = repository.findById(id);
		if (student != null && (student.get().getPassword().equals(password))) {
			return true;
		}
		return false;
	}

}
