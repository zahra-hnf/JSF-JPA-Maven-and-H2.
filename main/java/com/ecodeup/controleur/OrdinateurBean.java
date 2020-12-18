package com.ecodeup.controleur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.util.List;
import java.util.Map;
import com.ecodeup.model.*;
import com.ecodeup.dao.IOrdinateurDAO;
import com.ecodeup.dao.OrdinateurDAO;
@ManagedBean(name="ordinateurBean") 
@RequestScoped
public class OrdinateurBean 
{
	
	public String nouveau() {
		Ordinateur o = new Ordinateur();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("ordinateur", o);
		return  "/faces/creerOrdinateur.xhtml";
	}
	
	public String sauvegarder(Ordinateur ordinateur) {
		
		IOrdinateurDAO ordinateurDAO= new OrdinateurDAO();
		ordinateurDAO.sauvegarder(ordinateur);
		return  "/faces/index.xhtml";
	}
	
	public List<Ordinateur> selectionner()
	{
		
		IOrdinateurDAO  ordinateurDAO = new OrdinateurDAO();
		
		return ordinateurDAO.selectionner();
	}
	
	//modifier un ordinateur
	public String modifier(int code)
	{
			IOrdinateurDAO ordinateurDAO = new OrdinateurDAO();
			Ordinateur o = new Ordinateur();
			o = ordinateurDAO.chercher(code);
			System.out.println("******************************************");
			System.out.println(o);

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("ordinateur", o);
			return "/faces/modifier.xhtml";
		}
	
	//actualiser les ordinateurs
	public String actualiser(Ordinateur ordinateur)
	{
		IOrdinateurDAO ordinateurDAO = new OrdinateurDAO();
		ordinateurDAO.modifier(ordinateur);
		return "/faces/index.xhtml";
	}
	
	//supprimer un ordinateur
	public String supprimer(int code)
	{
		IOrdinateurDAO ordinateurDAO = new OrdinateurDAO();
		ordinateurDAO.supprimer(code);
		System.out.println("Ordinateur supprimé");
		return "/faces/index.xhtml";
	}
	
	
	
	
}
