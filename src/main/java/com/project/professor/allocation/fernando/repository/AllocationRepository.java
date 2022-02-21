package com.project.professor.allocation.fernando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.fernando.entity.Allocation;


@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>{

}
