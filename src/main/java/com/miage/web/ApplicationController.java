/**
 * 
 */
package com.miage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miage.metier.IAdminMetier;

/**
 * @author Specter
 *
 */
@Controller
public class ApplicationController {
	@Autowired
	private  IAdminMetier admin;
	
	@RequestMapping("/accueil")
	public String accueil() {
		return "accueil";
	}
	
	@RequestMapping("/service")
	public String service() {
		return "service";
	}
	
	@RequestMapping("/evenement")
	public String evenement() {
		return "evenement";
	}
	@RequestMapping("/galerie")
	public String galerie() {
		return "galerie";
	}
	@RequestMapping("/admin")
	public String apropos() {
		return "admin";
	}
}
