/**
 * 
 */
package com.miage.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.dao.AudioRepository;
import com.miage.dao.ClientRepository;

import com.miage.dao.LivreRepository;
import com.miage.dao.VideoRepository;

import com.miage.entities.Audio;
import com.miage.entities.Client;
import com.miage.entities.Employer;
import com.miage.entities.Livre;
import com.miage.entities.Video;

/**
 * @author Specter
 *
 */
@Controller
@RequestMapping("/employer")
public class employerController {

	@Autowired
	private ClientRepository c;

	@Autowired
	private VideoRepository v;
	@Autowired
	private LivreRepository l;
	@Autowired
	private AudioRepository au;

	/*
	 * Traitement sur client
	 */

	@RequestMapping(value = "/employer")
	public String admin() {
		return "Employer/employerTemplate";
	}

	@RequestMapping(value = "/accueil")
	public String accueil() {
		return "Employer/accueilEmployer";
	}

	@RequestMapping("/consultClient")
	public String consulClient(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		Page<Client> emp = c.findByName("%" + mc + "%", new PageRequest(p, 8));

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

	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
	public String addClient(Model model) {
		model.addAttribute("clientad", new Client());
		return "Employer/addClient";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Client cl, BindingResult b) {
		if (b.hasErrors()) {
			return "Employer/addClient";
		}
		c.save(cl);
		return "redirect:consultClient";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid Client ee, BindingResult b) {
		if (b.hasErrors()) {
			return "Employer/editClient";
		}
		Client e1 = ee;
		c.delete(ee);
		c.saveAndFlush(e1);
		return "redirect:consultClient";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long code, Model model) {
		Client em = c.getOne(code);
		model.addAttribute("employeredi", em);
		return "Employer/editClient";
	}

	@RequestMapping(value = "/supprimer")
	public String delete(Long code) {
		c.delete(code);
		return "redirect:consultClient";
	}

	/*
	 * Traitement sur média
	 */
	@RequestMapping(value = "/addm", method = RequestMethod.GET)
	public String addMedia(Model model) {
		return "Employer/addMedia";
	}

	/*
	 * Traitement audio
	 */

	@RequestMapping(value = "/adda", method = RequestMethod.GET)
	public String addAu(Model model) {
		// Employer ee = this.
		model.addAttribute("audioad", new Audio());
		return "Employer/addAudio";
	}

	@RequestMapping("/consultMedia")
	public String consultMedia() {
		return "Employer/consultMedia";
	}

	// Ajout Audio

	@RequestMapping("/consulta")
	public String consulta(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motClev", defaultValue = "") String mc) {
		Page<Audio> emp = au.findByName("%" + mc + "%", new PageRequest(p, 8));

		int nbPage = emp.getTotalPages();
		int[] pages = new int[nbPage];
		for (int i = 0; i < nbPage; i++)
			pages[i] = i;
		model.addAttribute("pagesa", pages);
		model.addAttribute("PageEmployera", emp);
		model.addAttribute("pageCouranta", p);
		model.addAttribute("motClea", mc);
		return "Employer/consultaudio";
	}

	@PostMapping("/savea")
	@RequestMapping(value = "/savea", method = RequestMethod.POST) // GET
	public String saveAudio(@ModelAttribute Audio aud, BindingResult b) {

		if (b.hasErrors()) {
			return "Employer/addAudio";
		}
		au.save(aud);
		return "redirect:consulta";
	}

	@RequestMapping(value = "/supprimerAudio")
	public String deleteAudio(Long code) {
		au.delete(code);
		return "redirect:consulta";
	}

	@RequestMapping(value = "/editAudio")
	public String editAudio(Long code, Model model) {
		Audio em = au.getOne(code);
		model.addAttribute("audioedi", em);
		return "Employer/editAudio";
	}

	@RequestMapping(value = "/updatea", method = RequestMethod.POST)
	public String updatea(@Valid Audio au1, BindingResult b) {
		if (b.hasErrors()) {
			return "Employer/editAudio";
		}
		au.save(au1);
		// Audio e1 = au1;
		// au.delete(au1);
		// au.saveAndFlush(e1);
		return "redirect:consulta";
	}

	/*
	 * Traitement video
	 */

	@RequestMapping(value = "/addv", method = RequestMethod.GET)
	public String addVi(Model model) {
		model.addAttribute("videoad", new Video());
		return "Employer/addVideo";
	}

	@RequestMapping(value = "/editVideo")
	public String editVideo(Long code, Model model) {
		Video em = v.getOne(code);
		model.addAttribute("videoedi", em);
		return "Employer/editVideo";
	}

	@RequestMapping(value = "/savev", method = RequestMethod.POST)
	public String saveVideo(@Valid Video v1, BindingResult b) {
		if (b.hasErrors()) {
			return "Employer/addVideo";
		}
		v.save(v1);
		return "redirect:consultv";
	}

	@RequestMapping(value = "/updatev", method = RequestMethod.POST)
	public String updatev(@Valid Video vid, BindingResult b) {
		if (b.hasErrors()) {
			return "Employer/editVideo";
		}
		Video e1 = vid;
		v.delete(vid);
		v.saveAndFlush(e1);
		return "redirect:consultv";
	}

	@RequestMapping(value = "/supprimerVideo")
	public String deleteVideo(Long code) {
		v.delete(code);
		return "redirect:consultv";
	}

	@RequestMapping("/consultv")
	public String consultv(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motClev", defaultValue = "") String mc) {
		Page<Video> emp = v.findByName("%" + mc + "%", new PageRequest(p, 8));

		int nbPage = emp.getTotalPages();
		int[] pages = new int[nbPage];
		for (int i = 0; i < nbPage; i++)
			pages[i] = i;
		model.addAttribute("pagesv", pages);
		model.addAttribute("PageEmployerv", emp);
		model.addAttribute("pageCourantv", p);
		model.addAttribute("motClev", mc);
		return "Employer/consultvideo";
	}

	/*
	 * Traitement livre
	 */
	@RequestMapping(value = "/savel", method = RequestMethod.POST)
	public String saveLivre(@Valid Livre v1, BindingResult b) {
		if (b.hasErrors()) {
			return "Employer/addLivre";
		}
		l.save(v1);
		return "redirect:consultl";
	}

	@RequestMapping(value = "/addl", method = RequestMethod.GET)
	public String addLi(Model model) {
		model.addAttribute("livread", new Livre());
		return "Employer/addLivre";
	}

	@RequestMapping("/consultl")
	public String consultl(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motClev", defaultValue = "") String mc) {
		Page<Livre> emp = l.findByName("%" + mc + "%", new PageRequest(p, 8));

		int nbPage = emp.getTotalPages();
		int[] pages = new int[nbPage];
		for (int i = 0; i < nbPage; i++)
			pages[i] = i;
		model.addAttribute("pagesl", pages);
		model.addAttribute("PageEmployerl", emp);
		model.addAttribute("pageCourantl", p);
		model.addAttribute("motClel", mc);
		return "Employer/consultlivre";
	}

	@RequestMapping(value = "/editLivre")
	public String editLivre(Long code, Model model) {
		Livre em = l.getOne(code);
		Livre em1 = em;
		Long idSave = em.getCodeMedia();
		em1.setCodeMedia(idSave);
		model.addAttribute("livredi", em1);
		l.delete(em); ////
		return "Employer/editLivre";
	}

	@RequestMapping(value = "/updatel", method = RequestMethod.POST)
	public String updatel(@Valid Livre liv, BindingResult b) {
		if (b.hasErrors()) {
			return "Employer/editLivre";
		}
		Long idd = liv.getCodeMedia();
		Livre e1 = liv;
		e1.setCodeMedia(idd);
		l.delete(liv);
		l.saveAndFlush(e1);
		return "redirect:consultl";
	}

	@RequestMapping(value = "/supprimerLivre")
	public String deleteLivre(Long code) {
		l.delete(code);
		return "redirect:consultl";
	}

	@RequestMapping("/parametre")
	public String parametre() {
		return "Employer/parametre";
	}

}
