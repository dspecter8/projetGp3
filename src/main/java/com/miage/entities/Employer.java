package com.miage.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("EMPLOY")
public class Employer extends Personne {
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateCreation = new Date();
	private String etat = "Non actif";
	private double salaire = 0.0;

	@ManyToOne
	@JoinColumn(name = "CODE_ADMIN")
	private Administrateur admin;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Client> clients;

	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Video> videos;
	
	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Audio> audios;
	
	@OneToMany(mappedBy = "employe", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Livre> livres;

	
	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employer(String nom, String prenom, String email, String motDePasse, String adress, Date dateCreation,
			String etat, Administrateur admin) {
		super(nom, prenom, email, motDePasse, adress);
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.admin = admin;
	}
	
	

	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param civilite
	 * @param motDePasse
	 * @param adress
	 * @param dateCreation
	 * @param etat
	 * @param salaire
	 * @param admin
	 */
	public Employer(String nom, String prenom, String email, String civilite, String motDePasse, String adress,String telephone,
			Date dateCreation, String etat, double salaire, Administrateur admin) {
		super(nom, prenom, email, civilite, motDePasse, adress,telephone);
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.salaire = salaire;
		this.admin = admin;
	}

	public Employer(String nom, String prenom, String email, String motDePasse, String adress, Date dateCreation,
			String etat, double salaire, Administrateur admin) {
		super(nom, prenom, email, motDePasse, adress);
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.salaire = salaire;
		this.admin = admin;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	/*
	 * public Collection<Operation> getOperations() { return operations; }
	 * 
	 * 
	 * 
	 * public void setOperations(Collection<Operation> operations) { this.operations
	 * = operations; }
	 */

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public Collection<Video> getVideos() {
		return videos;
	}

	public void setVideos(Collection<Video> videos) {
		this.videos = videos;
	}

	public Collection<Audio> getAudios() {
		return audios;
	}

	public void setAudios(Collection<Audio> audios) {
		this.audios = audios;
	}

	public Collection<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Collection<Livre> livres) {
		this.livres = livres;
	}

}
