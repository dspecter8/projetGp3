package com.miage.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RET")
public class Retour extends Operation{
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	public Retour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retour(Date dateOperation, Client client) {
		super(dateOperation);
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
