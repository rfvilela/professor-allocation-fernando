package com.project.professor.allocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.service.CourseService;

@RestController
public class CourseController {

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	private final CourseService courseService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<Course>> findAll(@RequestParam(name = "name", required = false) String name) {
        List<Course> courses = courseService.findAll(name);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
	
	@GetMapping(path = "/courses/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Course> findById(@PathVariable(name = "course_id") Long id) {

		Course courses = courseService.findById(id);

		if (courses != null) {
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(courses, HttpStatus.NOT_FOUND);
		}
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/courses/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> create(@RequestBody Course course) {

		try {
			Course newCourse = courseService.create(course);
			return new ResponseEntity<Course>(newCourse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path = "/courses/{course_id}\"", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Course> update(@PathVariable(name = "course_id") Long id,
			@RequestBody Course course) {

		course.setId(id);

		try {
			Course newCourse = courseService.create(course);
			if (newCourse != null) {
				return new ResponseEntity<Course>(newCourse, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/courses/{course_id}\"")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "course_id") Long id)
	{
		courseService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/courses/")
	public ResponseEntity<Void> deleteAll()
	{
		courseService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
	
	}


	
	

