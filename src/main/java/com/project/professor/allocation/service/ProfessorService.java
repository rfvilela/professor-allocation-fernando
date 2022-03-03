package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

public class ProfessorService {

	private final ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}

	// CRUD READ all
	public List<Professor> findAll() {

		List<Professor> professors = professorRepository.findAll();
		return professors;
	}

	// CRUD READ by ID
	public Professor findById(Long id) {
		Optional<Professor> optional = professorRepository.findById(id);
		Professor professor = optional.orElse(null);
		return professor;
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
		if (professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}
	}

	public void deleteAll() {

		professorRepository.deleteAllInBatch();
	}

	private Professor saveInternal(Professor professor) {
		Professor professorNew = professorRepository.save(professor);
		return professorNew;
	}

}
