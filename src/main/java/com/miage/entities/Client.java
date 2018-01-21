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
@DiscriminatorValue("CLIENT")
public class Client extends Personne {
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date debutAbonnement;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date finAbonnement;
	
	private int etatAbonnement = 1;

	@ManyToOne
	@JoinColumn(name = "CODE_EMPL")
	private Employer employe;
	

/*	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Operation> operations;*/

	//@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Emprunt> emprunts;
	
	//@OneToMany(mappedBy = "client", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	//@OneToMany(mappedBy = "client", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE, orphanRemoval = false)
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Retour> retours;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Client(String nom, String prenom, String email, String motDePasse, String adress, Date debutAbonnement,
			Date finAbonnement, int etatAbonnement, Employer employe) {
		super(nom, prenom, email, motDePasse, adress);
		this.debutAbonnement = debutAbonnement;
		this.finAbonnement = finAbonnement;
		this.etatAbonnement = etatAbonnement;
		this.employe = employe;
	}
	

	public Client(String nom, String prenom, String email, String civilite, String motDePasse, String adress,String telephone,
			Date debutAbonnement, Date finAbonnement, int etatAbonnement, Employer employe) {
		super(nom, prenom, email, civilite, motDePasse, adress,telephone);
		this.debutAbonnement = debutAbonnement;
		this.finAbonnement = finAbonnement;
		this.etatAbonnement = etatAbonnement;
		this.employe = employe;
		
	}


	public Employer getEmploye() {
		return employe;
	}

	public void setEmploye(Employer employe) {
		this.employe = employe;
	}

	public Date getDebutAbonnement() {
		return debutAbonnement;
	}

	public void setDebutAbonnement(Date debutAbonnement) {
		this.debutAbonnement = debutAbonnement;
	}

	public Date getFinAbonnement() {
		return finAbonnement;
	}

	public void setFinAbonnement(Date finAbonnement) {
		this.finAbonnement = finAbonnement;
	}

	public int getEtatAbonnement() {
		return etatAbonnement;
	}

	public void setEtatAbonnement(int etatAbonnement) {
		this.etatAbonnement = etatAbonnement;
	}


	public Collection<Emprunt> getEmprunts() {
		return emprunts;
	}


	public void setEmprunts(Collection<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}


	public Collection<Retour> getRetours() {
		return retours;
	}


	public void setRetours(Collection<Retour> retours) {
		this.retours = retours;
	}

	
	
/*	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
*/
}
