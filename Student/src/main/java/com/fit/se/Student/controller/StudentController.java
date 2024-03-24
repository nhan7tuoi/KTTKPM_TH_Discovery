package com.fit.se.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fit.se.Student.entity.Student;
import com.fit.se.Student.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/list")
	public List<Student> getAll(){
		return service.getAll();
	}
}
