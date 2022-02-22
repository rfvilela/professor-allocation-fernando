package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;

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

public class ProfessorRepositoryTest {

	@Autowired
	ProfessorRepository professorRepository;

	@Test
	public void findAll() {
		// Act
		List<Professor> prof = professorRepository.findAll();
		// Print
		System.out.println(prof);
	}

	@Test
	public void findById() {
		// Arrange
		
		// Act
		Optional<Professor> optional = professorRepository.findById(2L);
		// Print
		Professor professor = optional.orElseGet(null);
		System.out.println(professor);
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
		Professor prof = new Professor();
		prof.setCpf("12345678912");
		prof.setDepartmentId(2L);
		prof.setName("Joao");
		// Act
		Professor professor = professorRepository.save(prof);
		// Print
		System.out.println(professor);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange
		Professor prof = new Professor();
		prof.setId(2L);
		prof.setCpf("12345678912");
		prof.setDepartmentId(2L);
		prof.setName("Joao");
		// Act
		Professor professor = professorRepository.save(prof);
		// Print
		System.out.println(professor);
	}

	@Test
	public void deleteById() {
		// Arrange

		// Act
		professorRepository.deleteById(2L);	
	}

	@Test
	public void deleteAll() {
		// Act
		professorRepository.deleteAllInBatch();
	}
}