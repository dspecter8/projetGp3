package com.miage.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@DiscriminatorValue("LI")
public class Livre extends Media {
	private String auteur;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date anneeDeSortie;
	
	private String nomEdition;
	private int nombrePage;

	@ManyToOne
	@JoinColumn(name="CODE_EMPLOYER")
	private Employer employe;
	
	@ManyToOne
	@JoinColumn(name="EMPRUNT")
	private Emprunt emprunt;
	
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livre(String nom, int quantite, int etat, Date dateCreation, String description,
			String photo, Employer employe, String auteur, Date anneeDeSortie, String nomEdition, int nombrePage) {
		super(nom, quantite, etat, dateCreation, description, photo);
		this.auteur = auteur;
		this.anneeDeSortie = anneeDeSortie;
		this.nomEdition = nomEdition;
		this.nombrePage = nombrePage;
		this.employe = employe;
	}
	
	

	/**
	 * @param codeMedia
	 * @param nom
	 * @param quantite
	 * @param etat
	 * @param dateCreation
	 * @param description
	 * @param photo
	 * @param auteur
	 * @param anneeDeSortie
	 * @param nomEdition
	 * @param nombrePage
	 * @param employe
	 */
	public Livre(Long codeMedia, String nom, int quantite, int etat, Date dateCreation, String description,
			String photo, String auteur, Date anneeDeSortie, String nomEdition, int nombrePage, Employer employe) {
		super(codeMedia, nom, quantite, etat, dateCreation, description, photo);
		this.auteur = auteur;
		this.anneeDeSortie = anneeDeSortie;
		this.nomEdition = nomEdition;
		this.nombrePage = nombrePage;
		this.employe = employe;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getAnneeDeSortie() {
		return anneeDeSortie;
	}

	public void setAnneeDeSortie(Date anneeDeSortie) {
		this.anneeDeSortie = anneeDeSortie;
	}

	public String getNomEdition() {
		return nomEdition;
	}

	public void setNomEdition(String nomEdition) {
		this.nomEdition = nomEdition;
	}

	public int getNombrePage() {
		return nombrePage;
	}

	public void setNombrePage(int nombrePage) {
		this.nombrePage = nombrePage;
	}

	public Employer getEmploye() {
		return employe;
	}

	public void setEmploye(Employer employe) {
		this.employe = employe;
	}

//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}

	
}
