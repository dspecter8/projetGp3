package com.miage.metier;

import org.springframework.data.domain.Page;

import com.miage.entities.Audio;
import com.miage.entities.Client;
import com.miage.entities.Employer;
import com.miage.entities.Livre;
import com.miage.entities.Media;
import com.miage.entities.Video;

/**
 * @author Specter
 *
 */
public interface IEmployerMetier {

	// Client
	public Client consulterClient(Long codeClient);
	public void ajouterClient(Client client);
	public Page rechercherClient(String codeclient);
	public Page rechercherClientParNom(String nom);
	public Page rechercherClientParEtatAbonnement(int e);
	
	public void modifierClient(Long codeclient, Client client);
	public void desactiverClient(Long codeclient);
	public void activerClient(Long codeclient);
	public Page<Client> lstClient(Long codeclient, int page, int siez);

	// Media
	public Media consulterMedia(String codeMedia);

	public void ajouterLivre(Livre media);
	public void ajouterVideo(Video media);
	public void ajouterAudio(Audio media);

	public void modifierMedia(String codeMedia, Media media);

	public void desactiverMedia(String codeMedia);

	public void activerMedia(String codeMedia);

	public Page<Media> lstMedia(String codeMedia, int page, int siez);

	public Page rechercherMediaByName(String codeclient);


	// AbonnementClient
	/*
	 * To Do
	 */
	// EmpruntClient
	/*
	 * To Do
	 */

}
