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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.service.AllocationService;

@RestController
public class AllocationController {

	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}

	private final AllocationService allocationService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/allocations", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<Allocation>> findAll() {

		List<Allocation> allocations = allocationService.findAll();

		return new ResponseEntity<>(allocations, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/allocations/{allocation_id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Allocation> findById(@PathVariable(name = "allocation_id") Long id) {

		Allocation allocations = allocationService.findById(id);

		if (allocations != null) {
			return new ResponseEntity<>(allocations, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(allocations, HttpStatus.NOT_FOUND);
		}
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/allocations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Allocation> create(@RequestBody Allocation allocation) {

		try {
			Allocation newAllocation = allocationService.create(allocation);
			return new ResponseEntity<Allocation>(newAllocation, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path = "/allocations/{allocation_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Allocation> update(@PathVariable(name = "allocation_id") Long id,
			@RequestBody Allocation allocation) {

		allocation.setId(id);

		try {
			Allocation newAllocation = allocationService.create(allocation);
			if (newAllocation != null) {
				return new ResponseEntity<Allocation>(newAllocation, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/allocations/{allocation_id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "allocation_id") Long id)
	{
		allocationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/allocations")
	public ResponseEntity<Void> deleteAll()
	{
		allocationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
