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

import com.miage.dao.AudioRepository;
import com.miage.dao.ClientRepository;
import com.miage.dao.EmployerRepository;
import com.miage.dao.LivreRepository;
import com.miage.dao.VideoRepository;
import com.miage.entities.Administrateur;
import com.miage.entities.Audio;
import com.miage.entities.Client;
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
//@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository c;

	Administrateur a = new Administrateur();
	
	@RequestMapping(value = "/addc", method = RequestMethod.GET)
	public String addClient(Model model) {
		model.addAttribute("clientad", new Client());
		return "redirect:login";
	}
	
	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public String save(@Valid Client cl, BindingResult b) {
		if (b.hasErrors()) {
			return "redirect:login";
		}
		c.save(cl);
		return "redirect:compteCreer";
	}
/*	
	@RequestMapping("/consult")
	public String consultEmpl(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Client> emp = c.findClientByName("%" + mc + "%", new PageRequest(p, 8));
		int nbPage = emp.getTotalPages();
		int[] pages = new int[nbPage];
		for (int i = 0; i < nbPage; i++)
			pages[i] = i;
		model.addAttribute("pages", pages);
		model.addAttribute("PageEmployer", emp);
		model.addAttribute("pageCourant", p);
		model.addAttribute("motCle", mc);
		return "Employer/consultClient";
	}
	
	@RequestMapping(value = "/client")
	public String admin() {
		return "client/clientTemplate";
	}
	@RequestMapping(value = "/accueil")
	public String accueil() {		
		return "client/accueilEmployer";
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
	}*/

}
