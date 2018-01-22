package com.miage.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("EMP")
public class Emprunt extends Operation {
	
	private Date dateLimit;
//	@ManyToOne
//	@JoinColumn(name="CODE_CLI")
//	private Client client;
	
	@OneToMany(mappedBy = "emprunt", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Livre> livres;

	@OneToMany(mappedBy = "emprunt", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Audio> audios;
	
	
	@OneToMany(mappedBy = "emprunt", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = false)
	private Collection<Video> videos;
	public Emprunt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emprunt(Date dateOperation, Client client, Media m, Date dateLimit) {
		super(dateOperation, client,m);
		this.dateLimit= dateLimit;
	}

	public Date getDateLimit() {
		return dateLimit;
	}

	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}

//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}

}
