package com.project.professor.allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Usuario;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, String>{
	
	

}
