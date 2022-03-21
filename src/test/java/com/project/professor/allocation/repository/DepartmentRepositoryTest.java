package com.project.professor.allocation.repository;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	public void findAll() {
		// Act
		List<Department> depto = departmentRepository.findAll();
		// Print
		System.out.println(depto);
	}

	@Test
	public void findById() {
		// Arrange

		// Act
		Optional<Department> optional = departmentRepository.findById(2L);
		// Print
		Department depto = optional.orElseGet(null);
		System.out.println(depto);
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
		Department depto = new Department();
		depto.setName("Area2");
		
		// Act
		Department dept = departmentRepository.save(depto);
		// Print
		System.out.println(dept);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange
		Department depto = new Department();
		depto.setId(2L);
		depto.setName("Cin");
		// Act
		Department dept = departmentRepository.save(depto);
		// Print
		System.out.println(dept);
	}

	@Test
	public void deleteById() {
		// Arrange

		// Act
		departmentRepository.deleteById(2L);
	}

	@Test
	public void deleteAll() {
		// Act
		departmentRepository.deleteAllInBatch();
	}
}