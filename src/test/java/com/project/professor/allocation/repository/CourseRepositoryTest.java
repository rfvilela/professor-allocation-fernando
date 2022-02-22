package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Department;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findAll() {
		// Act
		List<Course> course = courseRepository.findAll();
		// Print
		System.out.println(course);
	}

	@Test
	public void findById() {
		// Arrange

		// Act
		Optional<Course> optional = courseRepository.findById(2L);
		// Print
		Course course = optional.orElseGet(null);
		System.out.println(course);
		// Print

	}

	@Test
	public void findByProfessorId() {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void findByCourseId() {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void save_create() throws ParseException {
		// Arrange
		Course course = new Course();
		course.setName("Desenvolvimento de Sistemdas");
		// Act
		Course curso = courseRepository.save(course);
		// Print
		System.out.println(curso);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange
		Course course = new Course();
		course.setId(2L);
		course.setName("Desenvolvimento de Sistemdas");
		// Act
		Course curso = courseRepository.save(course);
		// Print
		System.out.println(curso);
	}

	@Test
	public void deleteById() {
		// Arrange

		// Act
		courseRepository.deleteById(2L);
	}

	@Test
	public void deleteAll() {
		// Act
		courseRepository.deleteAllInBatch();
	}
}
