package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}

	// CRUD READ all
	public List<Allocation> findAll() {

		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;
	}

	// CRUD READ by ID
	public Allocation findById(Long id) {
		Optional<Allocation> optional = allocationRepository.findById(id);
		Allocation allocations = optional.orElse(null);
		return allocations;
	}

	public Allocation create(Allocation allocation) {

		allocation.setId(null);
		Allocation allocationNew =  allocationRepository.save(allocation);
		return allocationNew;

	}

	// CRUD: Update
	public Allocation update(Allocation allocation) {
		
		Allocation allocationNew = allocationRepository.save(allocation);
		return allocationNew;
	}
}
