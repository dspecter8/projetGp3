package com.miage.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miage.entities.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {
	@Query("select m from Media m where m.codeMedia=:x")
	public Page<Media> lstMedia(@Param("x")Long idcli, Pageable pageable);
	
	
	@Query("select e from Media e where e.nom like :x")
	public Page<Media> findByName(@Param("x")String mc,Pageable pageable);
	
}
