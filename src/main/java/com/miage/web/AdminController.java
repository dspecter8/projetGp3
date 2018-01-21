/**
 * 
 */
package com.miage.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.miage.dao.AdministrateurRepository;
import com.miage.dao.AudioRepository;
import com.miage.dao.EmployerRepository;
import com.miage.dao.LivreRepository;
import com.miage.dao.VideoRepository;
import com.miage.entities.Administrateur;
import com.miage.entities.Audio;
import com.miage.entities.Employer;
import com.miage.entities.Livre;
import com.miage.entities.Video;
import com.miage.metier.IAdminMetier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Specter
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminMetier admin;

	@Autowired
	private EmployerRepository e;
	
	@Autowired
	private AdministrateurRepository ar;
	
	@Autowired
	private VideoRepository v;
	@Autowired
	private LivreRepository l;
	@Autowired
	private AudioRepository au;

	Administrateur utilsateurCourant;// = new Administrateur();

	@RequestMapping("/consult")
	public String consultEmpl(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Employer> emp = e.findByName("%" + mc + "%", new PageRequest(p, 8));
		int nbPage = emp.getTotalPages();
		int[] pages = new int[nbPage];
		for (int i = 0; i < nbPage; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		model.addAttribute("PageEmployer", emp);
		model.addAttribute("pageCourant", p);
		model.addAttribute("motCle", mc);
		return "adm/consultEmpl";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployer(Model model) {
		//utilsateurCourant = ar.getOne();
		model.addAttribute("employerad", new Employer());
		return "adm/addEmployer";
	}

	@RequestMapping(value = "/admin")
	public String admin() {
		return "adm/admin";
	}
	@RequestMapping(value = "/accueil")
	public String accueil() {		
		return "adm/accueilAdmin";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Employer e, BindingResult b) {
		if (b.hasErrors()) {
			return "adm/addEmployer";
		}
		admin.ajouterEmployer(e);
		return "redirect:consult";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid Employer ee, BindingResult b) {
		if (b.hasErrors()) {
			return "adm/editEmployer";
		}
		Employer e1 = ee;
		e.delete(ee);
		e.saveAndFlush(e1);
		return "redirect:consult";
	}

	@RequestMapping(value = "/supprimer")
	public String delete(Long code) {
		e.delete(code);
		return "redirect:consult";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long code, Model model) {
		Employer em = e.getOne(code);
		model.addAttribute("employeredi", em);
		return "adm/editEmployer";
	}

	// Consultation média
	@RequestMapping("/consultv")
	public String consultv(Model model) {
		List<Video> vi = v.findAll();
		model.addAttribute("mediav", vi);
		return "adm/consultvideo";
	}

	@RequestMapping("/consultl")
	public String consultl(Model model) {
		List<Livre> li = l.findAll();
		model.addAttribute("medial", li);
		return "adm/consultlivre";
	}

	@RequestMapping("/consulta")
	public String consulta(Model model) {
		List<Audio> aa = au.findAll();
		model.addAttribute("mediaa", aa);
		return "adm/consultaudio";
	}

	
	@RequestMapping("/parametre")
	public String parametre() {
		return "adm/parametre";
	}

}
