package com.miage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miage.entities.Emprunt;

 

public interface EmpruntRepository extends JpaRepository<Emprunt, Long>{
	
//	@Query("select e.media  from Emprunt e   where    and e.client=:x ")
//	Page<Media> consultermVideoEmpBy(@Param("x")Client client, Pageable pageable);

	

}
