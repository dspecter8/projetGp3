package com.miage.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miage.entities.Audio;

public interface AudioRepository extends JpaRepository<Audio, Long> {
	@Query("select m from Audio m where m.codeMedia=:x")
	public Page<Audio> lstMedia(@Param("x")String idcli, Pageable pageable);
	
	
	@Query("select e from Audio e where e.nom like :x")
	public Page<Audio> findByName(@Param("x")String mc,Pageable pageable);
	
	@Query("select e from Audio e where e.etat=:x")
	public Page<Audio> lstMediaDispo(@Param("x")int etat, Pageable pageable);
	
	@Query("select e from Audio e where e.etat=:x")
	public Page<Audio> lstMediaIndispo(@Param("x")int etat, Pageable pageable);
	
}
