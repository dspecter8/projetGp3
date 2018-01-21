package com.miage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miage.entities.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
	
}
