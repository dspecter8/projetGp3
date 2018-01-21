package com.miage.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("AU")
public class Audio extends Media {
	private String chateur;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date anneeDeSortie;
	private String nomStudio;
	private String photo;

	@ManyToOne
	@JoinColumn(name = "CODE_EMPLOYER")
	private Employer employe;

	@ManyToOne
	@JoinColumn(name = "EMPRUNT")
	private Emprunt emprunt;

	public Audio() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Audio(String nom, int quantite, int etat, Date dateCreation, String description, String photo,
//			Employer employe, String chateur, Date anneeDeSortie, String nomStudio) {
//		super(nom, quantite, etat, dateCreation, description);
//		this.chateur = chateur;
//		this.anneeDeSortie = anneeDeSortie;
//		this.nomStudio = nomStudio;
//		this.employe = employe;
//
//	}

	public Audio(String nom, int quantite, int etat, Date dateCreation, String description, String photo,
			Employer employe, String chateur, Date anneeDeSortie, String nomStudio) {
		super(nom, quantite, etat, dateCreation, description);
		this.chateur = chateur;
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
	 * @param chateur
	 * @param anneeDeSortie
	 * @param nomStudio
	 * @param employe
	 */
	public Audio(Long codeMedia, String nom, int quantite, int etat, Date dateCreation, String description,
			String photo, String chateur, Date anneeDeSortie, String nomStudio, Employer employe) {
		super(codeMedia, nom, quantite, etat, dateCreation, description);
		this.chateur = chateur;
		this.anneeDeSortie = anneeDeSortie;
		this.nomStudio = nomStudio;
		this.employe = employe;
		this.photo = photo;
	}

	/**
	 * @param chateur
	 * @param anneeDeSortie
	 * @param nomStudio
	 * @param employe
	 * @param emprunt
	 */
	public Audio(String chateur, Date anneeDeSortie, String nomStudio, Employer employe, Emprunt emprunt) {
		super();
		this.chateur = chateur;
		this.anneeDeSortie = anneeDeSortie;
		this.nomStudio = nomStudio;
		this.employe = employe;
		this.emprunt = emprunt;
	}

	public String getChateur() {
		return chateur;
	}

	public void setChateur(String chateur) {
		this.chateur = chateur;
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

	// public Client getClient() {
	// return client;
	// }
	//
	//
	// public void setClient(Client client) {
	// this.client = client;
	// }

}
