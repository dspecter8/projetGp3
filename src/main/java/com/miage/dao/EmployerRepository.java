package com.miage.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miage.entities.Employer;
import com.miage.entities.Personne;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
	@Query("select e from Employer e where e.code=:x")
	public Page<Employer> lstEmployer(@Param("x")Long idEmpl, Pageable pageable);
	
	@Query("select e from Employer e where e.nom like :x")
	public Page<Employer> findByName(@Param("x")String mc,Pageable pageable);
	
	@Query("select e from Employer e where e.etat=1")
	public Page<Employer> lstEmployerActive(@Param("x")int etat, Pageable pageable);
	
	@Query("select e from Employer e where e.etat=0")
	public Page<Employer> lstEmployerDesactive(@Param("x")int etat, Pageable pageable);
	
	@Modifying
	@Query("update Employer e set e.etat=:etat where e.code=:id ")
	public void activate(@Param("etat")String etat,@Param("id") Long id);
	
	@Modifying
	@Query("update Employer e set e.etat =:etat where e.code= :id ")
	public void desactivate(@Param("etat") String etat,@Param("id") Long id);
	
	@Modifying
	@Query("update Employer e set e.salaire = :x where e.id = :id ")
	public void updateSalaire(@Param("x")double salaire,@Param("id") Long id);
	
	@Modifying
	@Query("update Employer e set e.email = :email")
	public void updateEmail(@Param("email")String email);
	
	@Query("delete from Personne e where e.code =:x")
	public void deleteEmployer(@Param("x")Long idEmp);
	
	
	
}
