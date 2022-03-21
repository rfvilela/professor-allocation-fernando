package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;
	   private final DepartmentService departmentService;
	    private final AllocationRepository allocationRepository;


	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService,
            AllocationRepository allocationRepository) {
		super();
		this.professorRepository = professorRepository;
	    this.departmentService = departmentService;
        this.allocationRepository = allocationRepository;
    }
	

	// CRUD READ all
	public List<Professor> findAll(String name) {
		 if (name == null) {
	            return professorRepository.findAll();
	        } else {
	            return professorRepository.findByNameContainingIgnoreCase(name);
	        }
	    }
	// CRUD READ by ID
	public Professor findById(Long id) {
		Optional<Professor> optional = professorRepository.findById(id);
		Professor professor = optional.orElse(null);
		return professor;
	}
	public List<Professor> findByDepartment(Long departmentId) {
        return professorRepository.findByDepartmentId(departmentId);
    }

	public Professor create(Professor professor) {

		professor.setId(null);
		return saveInternal(professor);
	}

	// CRUD: Update
	public Professor update(Professor professor) {

		Long id = professor.getId();
		if (id != null && professorRepository.existsById(id)) {

			return saveInternal(professor);
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (id != null && professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}
	}

	public void deleteAll() {

		professorRepository.deleteAllInBatch();
	}

	 private Professor saveInternal(Professor professor) {
	        professor = professorRepository.save(professor);

	        Department department = departmentService.findById(professor.getDepartmentId());
	        professor.setDepart(department);

	        List<Allocation> allocations = allocationRepository.findByProfessorId(professor.getId());
	        professor.setAllocations(allocations);

	        return professor;
	}

}
