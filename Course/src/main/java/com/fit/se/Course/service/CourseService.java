package com.fit.se.Course.service;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fit.se.Course.entity.Course;

@Service
public class CourseService {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;
	
	public CourseService( RedisTemplate redisTemplate) {
		super();
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}
	
	public void save(Course course) {
		hashOperations.put("Course", course.getId(), course);
	}
	
	public List<Course> getAllCourse(){
		return hashOperations.values("Course");
	}
	
	public void upadate(Course course) {
		save(course);
	}
	
	public void delete(int id) {
		hashOperations.delete("Course", id);
	}
	
}
