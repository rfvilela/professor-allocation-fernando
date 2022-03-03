package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	// CRUD READ all
	public List<Department> findAll() {

		List<Department> departments = departmentRepository.findAll();
		return departments;
	}

	// CRUD READ by ID
	public Department findById(Long id) {
		Optional<Department> optional = departmentRepository.findById(id);
		Department departments = optional.orElse(null);
		return departments;
	}

	public Department create(Department department) {

		department.setId(null);
		return saveInternal(department);
	}

	// CRUD: Update
	public Department update(Department department) {

		Long id = department.getId();
		if (id != null && departmentRepository.existsById(id)) {
			return saveInternal(department);
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}
	}

	public void deleteAll() {

		departmentRepository.deleteAllInBatch();
	}

	private Department saveInternal(Department department) {
		Department departmentNew = departmentRepository.save(department);
		return departmentNew;

	}

}
