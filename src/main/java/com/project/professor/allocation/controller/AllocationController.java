package com.project.professor.allocation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.service.AllocationService;

@RestController
public class AllocationController {
	
	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}

	private final AllocationService allocationService;

}
