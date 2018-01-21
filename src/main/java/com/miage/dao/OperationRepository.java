package com.miage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miage.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
}
