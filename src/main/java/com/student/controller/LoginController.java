package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.student.dto.StudentDto;
import com.student.model.SolrStudent;
import com.student.repository.solr.SolrRepository;
import com.student.service.StudentService;

@Controller
public class LoginController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SolrRepository repository;

	@GetMapping("/login")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login");
		StudentDto newStudent = new StudentDto();
		mav.addObject("student", newStudent);
		return mav;
	}

	@PostMapping("/AuthStudent")
	public String AuthUser(@ModelAttribute("StudentDto") StudentDto dto) {
		if (repository.existsById(dto.getStudentId())) {
			SolrStudent stud = new SolrStudent();
			stud = repository.getByStudentId(dto.getStudentId());
			if (stud.getPassword().equals(dto.getPassword())) {
				return "redirect:login/details/" + dto.getStudentId();
			}
		}
			return "redirect:/login?error";
	}
	
	@GetMapping("/login/details/{id}")
	public ModelAndView getUser(@PathVariable String id){
		ModelAndView mav = new ModelAndView("student-details");
		mav.addObject("student", studentService.getUser(id));
		return mav;
        
    
    }

}
