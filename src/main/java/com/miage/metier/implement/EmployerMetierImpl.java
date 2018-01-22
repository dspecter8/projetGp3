package com.miage.metier.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miage.dao.AudioRepository;
import com.miage.dao.ClientRepository;
import com.miage.dao.LivreRepository;
import com.miage.dao.MediaRepository;
import com.miage.dao.VideoRepository;
import com.miage.entities.Audio;
import com.miage.entities.Client;
import com.miage.entities.Livre;
import com.miage.entities.Media;
import com.miage.entities.Video;
import com.miage.metier.IEmployerMetier;

@Service
@Transactional
public class EmployerMetierImpl implements IEmployerMetier {

	@Autowired
	private ClientRepository cliRep;

	@Autowired
	private MediaRepository mediaRep;

/*	@Autowired
	private AudioRepository aRep;
	@Autowired
	private LivreRepository lRep;

	@Autowired
	private VideoRepository vRep;*/

	// Gestion client
	@Override
	public Client consulterClient(Long codeClient) {
		Client cli = cliRep.findOne(codeClient);
		if (cli == null)
			throw new RuntimeException("Client introuvable");
		return cli;
	}

	@Override
	public void ajouterClient(Client client) {
		cliRep.save(client);
	}

	@Override
	public Page rechercherClient(String mc) {

		return cliRep.findClientByName(mc, new PageRequest(1, 5));
	}

	@Override
	public void modifierClient(Long codeclient, Client client) {
		Client cli = consulterClient(codeclient);
		cli.setNom(client.getNom());
		cli.setPrenom(client.getPrenom());
		cli.setEmail(client.getEmail());
		cli.setMotDePasse(client.getMotDePasse());
		cli.setAdress(client.getAdress());
		cli.setDebutAbonnement(client.getDebutAbonnement());
		cli.setFinAbonnement(client.getFinAbonnement());
		cli.setEtatAbonnement(client.getEtatAbonnement());

	}

	@Override
	public void desactiverClient(Long codeclient) {
		Client cli = consulterClient(codeclient);
		cli.setEtatAbonnement(0);
	}

	@Override
	public void activerClient(Long codeclient) {
		Client cli = consulterClient(codeclient);
		cli.setEtatAbonnement(1);

	}

	@Override
	public Page<Client> lstClient(Long codeclient, int page, int siez) {

		return cliRep.lstClient(codeclient, new PageRequest(page, siez));
	}

	@Override
	public Media consulterMedia(Long codeMedia) {
		Media m = mediaRep.getOne(codeMedia);
		if (m == null)
			throw new RuntimeException("Media introuvable");
		return m;
	}

	@Override
	public void modifierMedia(Long codeMedia, Media media) {
		Media m = consulterMedia(codeMedia);
		if (m instanceof Livre) {
			Livre l = (Livre) m;
			l.setNom(((Livre) media).getNom());
			l.setAuteur(((Livre) media).getAuteur());
			l.setAnneeDeSortie(((Livre) media).getAnneeDeSortie());
			l.setDescription(((Livre) media).getDescription());
			l.setPhoto(((Livre) media).getPhoto());
			l.setNomEdition(((Livre) media).getNomEdition());
			l.setQuantite(((Livre) media).getQuantite());
			l.setEtat(((Livre) media).getEtat());
		} else if (m instanceof Audio) {
			Audio a = (Audio) m;
			a.setNom(((Audio) media).getNom());
			a.setChateur(((Audio) media).getChateur());
			a.setAnneeDeSortie(((Audio) media).getAnneeDeSortie());
			a.setDescription(((Audio) media).getDescription());
			a.setPhoto(((Audio) media).getPhoto());
			a.setNomStudio(((Audio) media).getNomStudio());
			a.setQuantite(((Audio) media).getQuantite());
			a.setEtat(((Audio) media).getEtat());
		} else {
			Video v = (Video) m;
			v.setNom(((Video) media).getNom());
			v.setActeur(((Video) media).getActeur());
			v.setAnneeDeSortie(((Video) media).getAnneeDeSortie());
			v.setDescription(((Video) media).getDescription());
			v.setPhoto(((Video) media).getPhoto());
			v.setNomStudio(((Video) media).getNomStudio());
			v.setQuantite(((Video) media).getQuantite());
			v.setEtat(((Video) media).getEtat());
		}
	}

	@Override
	public void desactiverMedia(Long codeMedia) {
		Media m = consulterMedia(codeMedia);
		m.setEtat(0);
	}

	@Override
	public void activerMedia(Long codeMedia) {
		Media m = consulterMedia(codeMedia);
		m.setEtat(1);

	}

	@Override
	public Page<Media> lstMedia(Long codeMedia, int page, int siez) {
		return mediaRep.lstMedia(codeMedia, new PageRequest(page, siez));
	}

	@Override
	public Page rechercherMediaByName(String nom) {
		return mediaRep.findByName(nom, new PageRequest(1, 5));
	}

	@Override
	public void ajouterLivre(Livre media) {
		mediaRep.save(media);

	}

	@Override
	public void ajouterVideo(Video media) {
		mediaRep.save(media);

	}

	@Override
	public void ajouterAudio(Audio media) {
		mediaRep.save(media);

	}

	@Override
	public Page rechercherClientParNom(String nom) {
		return cliRep.findClientByName(nom, new PageRequest(1, 5));
	}

	@Override
	public Page rechercherClientParEtatAbonnement(int e) {
		if (e == 1)
			return cliRep.lstClientActive(e, new PageRequest(1, 5));
		return cliRep.lstClientDesactive(e, new PageRequest(1, 5));
	}

}
