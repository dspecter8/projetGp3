package com.miage.metier;

import org.springframework.data.domain.Page;

import com.miage.entities.Administrateur;
import com.miage.entities.Client;
import com.miage.entities.Employer;
import com.miage.entities.Media;
import com.miage.entities.Personne;

/**
 * @author Specter
 *
 */
public interface IAdminMetier {
	
	public Personne loginConnect(String l,String mdp);
	
	// Ajout d'un employer
	public void ajouterEmployer(Employer employer);

	// Desactivation d'un employer
	public void desactiverEmployer(Long codeEmployer);

	// Activation d'un employer
	public void activerEmployer(Long codeEmployer);

	// Consultation d'un employer
	public Personne consulterEmployer(Long codeEmployer);
	public Personne consulterEmployer(String email);
	// Motification d'un employer
	public void modifierEmployer(Employer e);

	public void updateSalaireEmployer(double salaire, Long codeEmployer);

	// Suppression d'un employer
	public void supprimerEmployer(Long codeEmployer);

	// Affichage de la liste de employer
	public Page<Employer> lstEmployer(Long codeEmployer, int page, int siez);

	public Page<Employer> lstEmployerActive(int etat, int page, int siez);

	public Page<Employer> lstEmployerDesactive(int etat, int page, int siez);

	public Page<Employer> lstEmployerParNom(String nom, int page, int siez);

	/*public Administrateur consulterAdmin(Long codeEmployer);*/

}
