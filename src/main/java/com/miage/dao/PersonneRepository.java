package com.miage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miage.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
	@Query("select e from Personne e where e.email=:x")
	public Personne findPersonneByEmail(@Param("x")String mc);
	
}
