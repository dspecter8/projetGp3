package com.miage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.entities.Administrateur;
import com.miage.entities.Client;
import com.miage.entities.Employer;
import com.miage.entities.Personne;
import com.miage.metier.IAdminMetier;


@Controller
//@RequestMapping(value = "/in")
public class LoginController {

	@Autowired
	private IAdminMetier admin;
	
	public static Model modelstatic;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String connexionLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/addClient", method = RequestMethod.GET)
	public String addClient() {
		return "addClient";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verificationLogin(@RequestParam String email, @RequestParam String mdp, HttpSession session,
			Model model) {

		Personne p = admin.loginConnect(email, mdp);
		if (p == null) {
			model.addAttribute("loginError", "Erreur de connexion, Re-essayez SVP");
			return "login";
		}

		else if (p instanceof Administrateur) {
			Administrateur a = (Administrateur) p;
			session.setAttribute("loggedInUser", a);
			model.addAttribute("userConnect",a);
			model.addAttribute("perso1",a);
			
			modelstatic.addAttribute("perso", a);
			return "adm/admin";
		}

		else if (p instanceof Employer) {
			Employer e = (Employer) p;
			session.setAttribute("loggedInUser", e);
			model.addAttribute("userConnect",e);
			
			model.addAttribute("perso1",e);
			modelstatic.addAttribute("perso", e);
			return "Employer/employerTemplate";
		} else if (p instanceof Client) {
			Client c = (Client) p;
			session.setAttribute("loggedInUser", c);
			modelstatic.addAttribute("perso", c);
			model.addAttribute("perso1",c);
			model.addAttribute("userConnect",session.getId());
			return "client/clientTemplate";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession sesion) {
		sesion.removeAttribute("loggedInUser");
		return "redirect:/login";
	}

}
