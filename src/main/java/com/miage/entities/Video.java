package com.miage.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@DiscriminatorValue("VI")
public class Video extends Media{
	private String realisateur;
	private String acteur;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date anneeDeSortie;
	private String nomStudio;
	
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="CODE_EMPLOYER")
	private Employer employe;
	
	
	@ManyToOne
	@JoinColumn(name="EMPRUNT")
	private Emprunt emprunt;
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(String nom, int quantite, int etat, Date dateCreation, String description,
			String photo, Employer employe, String realisateur, String acteur, Date anneeDeSortie, String nomStudio) {
		super(nom, quantite, etat, dateCreation, description);
		this.realisateur = realisateur;
		this.acteur = acteur;
		this.anneeDeSortie = anneeDeSortie;
		this.nomStudio = nomStudio;
		this.employe = employe;
		this.photo = photo;
	}
	
	
	

	/**
	 * @param codeMedia
	 * @param nom
	 * @param quantite
	 * @param etat
	 * @param dateCreation
	 * @param description
	 * @param photo
	 * @param realisateur
	 * @param acteur
	 * @param anneeDeSortie
	 * @param nomStudio
	 * @param employe
	 */
	public Video(Long codeMedia, String nom, int quantite, int etat, Date dateCreation, String description,
			String photo, String realisateur, String acteur, Date anneeDeSortie, String nomStudio, Employer employe) {
		super(codeMedia, nom, quantite, etat, dateCreation, description);
		this.realisateur = realisateur;
		this.acteur = acteur;
		this.anneeDeSortie = anneeDeSortie;
		this.nomStudio = nomStudio;
		this.employe = employe;
		this.photo = photo;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public String getActeur() {
		return acteur;
	}

	public void setActeur(String acteur) {
		this.acteur = acteur;
	}

	public Date getAnneeDeSortie() {
		return anneeDeSortie;
	}

	public void setAnneeDeSortie(Date anneeDeSortie) {
		this.anneeDeSortie = anneeDeSortie;
	}

	public String getNomStudio() {
		return nomStudio;
	}

	public void setNomStudio(String nomStudio) {
		this.nomStudio = nomStudio;
	}

	public Employer getEmploye() {
		return employe;
	}

	public void setEmploye(Employer employe) {
		this.employe = employe;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
//
//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}
	
	
}
