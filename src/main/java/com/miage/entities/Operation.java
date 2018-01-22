package com.miage.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * @author Specter
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_OP", discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Operation implements Serializable {
	
	@Id
	@GeneratedValue
	private Long numero;
	private Date dateOperation;
	
	@ManyToOne
	@JoinColumn(name="CODE_MEDIA")
	private Media media;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
/*	@ManyToOne
	@JoinColumn(name="CODE_EMPL")
	private Employer employee;
	*/



/*	public Employer getEmployee() {
		return employee;
	}



	public void setEmployee(Employer employee) {
		this.employee = employee;
	}
*/



	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Operation(Date dateOperation,Client cli, Media m) {
		super();
		this.dateOperation = dateOperation;
		this.media = m;
		this.client= cli;
	}



	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

}
