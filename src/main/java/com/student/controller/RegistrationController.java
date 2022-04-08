package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.student.dto.StudentDto;
import com.student.model.SolrStudent;
import com.student.repository.solr.SolrRepository;
import com.student.service.StudentService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private SolrRepository solrRepository;

	@ModelAttribute("student")
	public StudentDto studentDto() {
		return new StudentDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "StudentForm";
	}

	@PostMapping
	public String registerStudent(@ModelAttribute("student") StudentDto studentDto) {

		if (solrRepository.existsById(studentDto.getStudentId())) {
			return "redirect:/registration?error";
		}
		SolrStudent stu=new SolrStudent(studentDto.getStudentId(), studentDto.getPassword());
		solrRepository.save(stu);

		System.out.println(studentDto);
		service.save(studentDto);

		return "redirect:/registration?success";
	}

}
