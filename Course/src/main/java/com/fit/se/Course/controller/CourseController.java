package com.fit.se.Course.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fit.se.Course.entity.Course;
import com.fit.se.Course.service.CourseService;
import com.fit.se.Course.service.RestTemplateService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private RestTemplateService restTemplateService;

	@GetMapping("/listCourse")
	public List<Course> getCourses() {
		return courseService.getAllCourse();
	}

	@GetMapping("/listStudents")
	public List<Map<String, Object>> getAllUsers() {
		List<Map<String, Object>> students = restTemplateService.getAllUser();
		return students;
	}
	@PostMapping("/addCourse")
	public Course createCourse(@RequestBody Course course) {
		System.out.println(course);
		courseService.save(course);
		return course;
	}
}
