package com.miage.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miage.entities.Client;
import com.miage.entities.Employer;

public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select c from Client c where c.code=:x")
	public Page<Client> lstClient(@Param("x") Long idcli, Pageable pageable);

	@Query("delete from Client c where c.code =:x")
	public void deleteClient(@Param("x") Long idcli);
	
	@Query("select e from Client e where e.nom like :x")
	public Page<Client> findByName(@Param("x")String mc,Pageable pageable);
	
	@Query("select c from Client c where c.nom like :x")
	public Page<Client> findClientByName(@Param("x") String mc, Pageable pageable);
	
	@Query("select e from Client e where e.etatAbonnement=:x")
	public Page<Client> lstClientActive(@Param("x")int etat, Pageable pageable);
	
	
	@Query("select e from Client e where e.etatAbonnement=:x")
	public Page<Client> lstClientDesactive(@Param("x")int etat, Pageable pageable);
	
	@Modifying
	@Query("update Client e set e.etatAbonnement=:etat where e.code=:id ")
	public void activate(@Param("etat")int etat,@Param("id") Long id);
	
	@Modifying
	@Query("update Client e set e.etatAbonnement =:etat where e.code= :id ")
	public void desactivate(@Param("etat") int etat,@Param("id") Long id);
	
}
