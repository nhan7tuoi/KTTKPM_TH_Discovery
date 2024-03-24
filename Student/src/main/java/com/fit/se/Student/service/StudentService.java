package com.fit.se.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.se.Student.entity.Student;
import com.fit.se.Student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public List<Student> getAll() {
		return repository.findAll();
	}
}
