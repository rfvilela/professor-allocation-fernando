package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;


public class CourseService {
	
	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	// CRUD READ all
		public List<Course> findAll() {

			List<Course> courses = courseRepository.findAll();
			return courses;
		}

		// CRUD READ by ID
		public Course findById(Long id) {
			Optional<Course> optional = courseRepository.findById(id);
			Course courses = optional.orElse(null);
			return courses;
		}
		
		

		public Course create(Course course) {

			course.setId(null);
			Course courseNew = courseRepository.save(course);
			return courseNew;
		}

		// CRUD: Update
		public Course update(Course course) {

			Long id = course.getId();
			if (id != null && courseRepository.existsById(id)) {

				Course courseNew = courseRepository.save(course);
				return courseNew;
			} else {
				return null;
			}
		}

		public void deleteById(Long id) {
			if (id != null && courseRepository.existsById(id)) {
				courseRepository.deleteById(id);
			}
		}

		public void deleteAll() {

			courseRepository.deleteAllInBatch();
		}
	

}
