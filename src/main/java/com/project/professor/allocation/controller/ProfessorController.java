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

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.service.ProfessorService;

public class ProfessorController {

public ProfessorController(ProfessorService professorService) {
		super();
		this.professorService = professorService;
	}

private final ProfessorService professorService;

@ResponseStatus(HttpStatus.OK)
@GetMapping(path = "/professors", produces = MediaType.APPLICATION_JSON_VALUE)

public ResponseEntity<List<Professor>> findAll(@RequestParam(name = "name", required = false) String name) {
    List<Professor> professors = professorService.findAll(name);
    return new ResponseEntity<>(professors, HttpStatus.OK);
}
@GetMapping(path = "/professors/{professor_id}", produces = MediaType.APPLICATION_JSON_VALUE)

public ResponseEntity<Professor> findById(@PathVariable(name = "professor_id") Long id) {


	Professor professors = professorService.findById(id);

	if (professors != null) {
		return new ResponseEntity<>(professors, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(professors, HttpStatus.NOT_FOUND);
	}
}
@ResponseStatus(HttpStatus.OK)
@GetMapping(path = "/departments/{departments_id}", produces = MediaType.APPLICATION_JSON_VALUE)

public ResponseEntity<List<Professor>> findByDepartment(@PathVariable(name = "departments_id") Long id) {
	List<Professor> professors = professorService.findByDepartment(id);
			return new ResponseEntity<>(professors, HttpStatus.OK);
	
}
@ResponseStatus(HttpStatus.CREATED)
@PostMapping(path = "/professors/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Professor> create(@RequestBody Professor professor) {


	try {
		Professor newProfessor = professorService.create(professor);
		return new ResponseEntity<Professor>(newProfessor, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
@ResponseStatus(HttpStatus.OK)
@PutMapping(path = "/professors/{professor_id}\"", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

public ResponseEntity<Professor> update(@PathVariable(name = "professor_id") Long id,
		@RequestBody Professor professor) {

	professor.setId(id);

	try {
		Professor newProfessor = professorService.create(professor);
		if (newProfessor != null) {
			return new ResponseEntity<Professor>(newProfessor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping(path = "/professors/{professor_id}\"")
public ResponseEntity<Void> deleteById(@PathVariable(name = "professor_id") Long id)
{
	professorService.deleteById(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping(path = "/professors/")
public ResponseEntity<Void> deleteAll()
{
	professorService.deleteAll();
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
}



}
