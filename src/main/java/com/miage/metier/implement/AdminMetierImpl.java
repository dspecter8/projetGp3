package com.miage.metier.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miage.dao.AdministrateurRepository;
import com.miage.dao.EmployerRepository;
import com.miage.dao.PersonneRepository;
import com.miage.entities.Administrateur;
import com.miage.entities.Client;
import com.miage.entities.Employer;
import com.miage.entities.Personne;
import com.miage.metier.IAdminMetier;

@Service
@Transactional
public class AdminMetierImpl implements IAdminMetier {
	@Autowired
	private EmployerRepository emRep;
	
	@Autowired
	private PersonneRepository peRep;

	@Override
	public void ajouterEmployer(Employer employer) {
		emRep.save(employer);
	}

	@Override
	public void desactiverEmployer(Long codeEmployer) {
		emRep.desactivate("Non actif", codeEmployer);

	}

	@Override
	public void activerEmployer(Long codeEmployer) {
		emRep.activate("Actif", codeEmployer);

	}

	@Override
	public Personne consulterEmployer(Long codeEmployer) {
		Personne p = emRep.findOne(codeEmployer);
		if (p == null) {
			throw new RuntimeException("Employer introuvable");
		}
		if (p instanceof Employer) {
			Employer em = (Employer) p;
			return em;
		}
		if (p instanceof Employer) {
			Administrateur ad = (Administrateur) p;
			return ad;
		}
		return null;
	}

	/*
	 * @Override public Administrateur consulterAdmin(Long codeEmployer) {
	 * Administrateur ad = adRep.findOne(codeEmployer); if (ad == null) throw new
	 * RuntimeException("Employer introuvable"); return ad; }
	 */
	//

	@Override
	public void modifierEmployer(Employer e) {
		Employer em = emRep.getOne(e.getCode());//(Employer) consulterEmployer(codeEmployer);
		em.setNom(e.getNom());
		em.setPrenom(e.getPrenom());
		em.setEmail(e.getEmail());
		em.setMotDePasse(e.getMotDePasse());
		em.setAdress(e.getAdress());
		em.setSalaire(e.getSalaire());
		em.setEtat(e.getEtat());
	}

	@Override
	public void supprimerEmployer(Long codeEmployer) {
		emRep.delete(codeEmployer);
	}

	@Override
	public Page<Employer> lstEmployer(Long codeEmployer, int page, int siez) {
		return emRep.lstEmployer(codeEmployer, new PageRequest(page, siez));
	}

	@Override
	public void updateSalaireEmployer(double salaire, Long codeEmployer) {
		emRep.updateSalaire(salaire, codeEmployer);

	}

	@Override
	public Page<Employer> lstEmployerActive(int etat, int page, int siez) {

		return emRep.lstEmployerActive(1, new PageRequest(page, siez));
	}

	@Override
	public Page<Employer> lstEmployerDesactive(int etat, int page, int siez) {

		return emRep.lstEmployerDesactive(0, new PageRequest(page, siez));
	}

	@Override
	public Page<Employer> lstEmployerParNom(String nom, int page, int siez) {

		return emRep.findByName(nom, new PageRequest(page, siez));
	}



	@Override
	public Personne consulterEmployer(String email) {
		Personne p = peRep.findPersonneByEmail(email);
		//Personne p = emRep.findOne(email);
		if (p == null) {
			throw new RuntimeException("Employer introuvable");
		}
		if (p instanceof Employer) {
			Employer em = (Employer) p;
			return em;
		}
		if (p instanceof Employer) {
			Administrateur ad = (Administrateur) p;
			return ad;
		}
		return null;
	}
	
	@Override
	public Personne loginConnect(String l, String mdp) {
		Personne p = peRep.findPersonneByEmail(l);
		if (p != null && (p instanceof Administrateur) && p.getMotDePasse().equals(mdp) && p.getEmail().equalsIgnoreCase(l)) {
			return (Administrateur) p;
		}else if (p != null && (p instanceof Employer) && p.getMotDePasse().equals(mdp) && p.getEmail().equalsIgnoreCase(l)) {
			return (Employer) p;
		}else if (p != null && (p instanceof Client) && p.getMotDePasse().equals(mdp) && p.getEmail().equalsIgnoreCase(l)) {
			return (Client) p;
		}
		return null;
	}
	
	

}
