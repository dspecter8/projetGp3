package com.miage.metier;

import org.springframework.data.domain.Page;

import com.miage.entities.Client;
import com.miage.entities.Media;

/**
 * @author Specter
 *
 */
public interface IClientMetier {
	
	public Long ajouterClient(Client c);
	public void activerClient(int etat, Long codeClient);
	public Client consulterClient(Long codeClient);
	public void consulterEmprunt(Long codeClient);
	public Media rechercherMediaByTags(String codeclient);
	public Page<Media> lstMedia(String codeMedia, int page, int siez);
}
