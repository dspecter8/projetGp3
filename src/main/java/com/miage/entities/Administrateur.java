package com.miage.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ADMINI")
public class Administrateur extends Personne {

	private double salaire = 0.0;
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
	private Collection<Employer> employers;

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String nom, String prenom, String email, String motDePasse, String adress) {
		super(nom, prenom, email, motDePasse, adress);
	}
	
	public Administrateur(String nom, String prenom, String email, String civilite, String motDePasse, String adress,String telephone,
			double salaire) {
		super(nom, prenom, email, civilite, motDePasse, adress,telephone);
		this.salaire = salaire;
	}

	public Administrateur(String nom, String prenom, String email, String motDePasse, String adress, double salaire) {
		super(nom, prenom, email, motDePasse, adress);
		this.salaire = salaire;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Collection<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(Collection<Employer> employers) {
		this.employers = employers;
	}

}
