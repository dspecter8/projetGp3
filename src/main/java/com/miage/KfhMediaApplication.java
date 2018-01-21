package com.miage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.miage.dao.AdministrateurRepository;
import com.miage.dao.ClientRepository;
import com.miage.dao.EmployerRepository;
import com.miage.dao.MediaRepository;
import com.miage.dao.OperationRepository;
import com.miage.entities.Administrateur;
import com.miage.entities.Audio;
import com.miage.entities.Client;
import com.miage.entities.Employer;
import com.miage.entities.Emprunt;
import com.miage.entities.Livre;
import com.miage.entities.Media;
import com.miage.entities.Operation;
import com.miage.entities.Personne;
import com.miage.metier.IAdminMetier;
import com.miage.metier.IEmployerMetier;

@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KfhMediaApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository cliRep;
	@Autowired
	private AdministrateurRepository AdmRep;
	@Autowired
	private MediaRepository mRep;
	@Autowired
	private EmployerRepository emplRep;
	@Autowired
	private OperationRepository opeRep;

	@Autowired
	public IAdminMetier admMetier;

	@Autowired
	public IEmployerMetier emMetier;

	public static void main(String[] args) {
		SpringApplication.run(KfhMediaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Administrateur adm1 = AdmRep.save(new Administrateur("dddd", "renjm", "Memail", "motDePasse", "adress"));
		Administrateur adm = AdmRep.save(new Administrateur("dddd", "renom", "Memail1", "motDePasse", "adress"));
		Employer empl1 = emplRep
				.save(new Employer("22", "prenom", "ema7il1", "motDePasse", "adress", new Date(), "Non actif", adm));
		Client client = cliRep.save(new Client("Client1nom", "Client1prenom", "Cli7ent1email", "Client1motDePasse",
				"Client1adress", new Date(), new Date(), 0, empl1));
		Employer em2 = new Employer("22111", "pre222nom", "emai7l2", "mot222DePasse", "ad2222ress", new Date(), "Non actif",
				adm);
		emplRep.save(em2);
		Employer em3 = new Employer("aaaa111aaaaaaaa", "pre222nom", "e8mail3", "mot222DePasse", "ad2222ress",
				new Date(), "Non actif", adm);
		Media media = mRep.save(new Audio("nom", 45, 1, new Date(), "description", "photo", empl1, "chateur",
				new Date(), "nomStudio"));
		Emprunt empr = opeRep.save(new Emprunt(new Date(), client));
		Employer emModif = new Employer("Modif11", "pre222nom", "email4", "mot222DePasse", "ad2222ress", new Date(),
				"Non actif", adm);
		// Test metier
		Livre l = new Livre("nom", 10000, 1, new Date(), "titi tata", "photo", empl1, "Toledo", new Date(),
				"nomEdition1", 45);
		//Livre lll = new Livre(nom, quantite, etat, dateCreation, description, photo, employe, auteur, anneeDeSortie, nomEdition, nombrePage)
		
		Livre l1 = new Livre("no4444m", 10000,441, new Date(), "tit4444444444i tata", "photo", empl1, "Toledo", new Date(),
				"nomEdition1", 45);
		emMetier.ajouterLivre(l);
		
		Client cl = new Client("Client1nom", "Client1Metierprenom", "ClieMetiernt1email", "ClientMetier1motDePasse", "ClientMetier1adress",
				new Date(), new Date(), 0, empl1);
		emMetier.ajouterClient(cl);
		admMetier.ajouterEmployer(em3);
		
		//emMetier.modifierMedia(l.getCodeMedia(), l1);
		
		admMetier.updateSalaireEmployer(1275.57, em2.getCode());
		admMetier.updateSalaireEmployer(1275.57, empl1.getCode());
		admMetier.updateSalaireEmployer(1275.57, em3.getCode());
		admMetier.activerEmployer(em2.getCode());

	}

}
