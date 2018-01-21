package com.miage.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_PERSONNE", discriminatorType=DiscriminatorType.STRING,length=6)
public abstract class Personne implements Serializable {

	@Id
	@GeneratedValue
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	private Long code;
	@NotEmpty
	@Column(length = 50)
	private String nom;
	@NotEmpty
	@Column(length = 50)
	private String prenom;
	@NotEmpty
	@Column(length = 50,unique = true)
	private String email;
	private String civilite;
	private String motDePasse;
	
	private String telephone;
	
	@Column(length = 150, nullable = false)
	private String adress;
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom, String email, String motDePasse, String adress) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.adress = adress;
	}
	
	
	/**
	 */
	public Personne(String nom, String prenom, String email, String civilite, String motDePasse, String adress,String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.civilite = civilite;
		this.motDePasse = motDePasse;
		this.adress = adress;
		this.telephone = telephone;
	}
	
	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	
}
