package com.ecodeup.controleur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.util.List;
import java.util.Map;
import com.ecodeup.model.*;
import com.ecodeup.dao.FormationDAO;
import com.ecodeup.dao.IFormationDAO;
import com.ecodeup.dao.IOrdinateurDAO;
import com.ecodeup.dao.OrdinateurDAO;

@ManagedBean(name="formationBean") 
@RequestScoped
public class FormationBean 
{
	
	public String nouveau() {
		Formation f = new Formation();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("formation", f);
		return  "/faces/creerFormation.xhtml";
	}
	
	public String sauvegarder(Formation formation) {
		
		IFormationDAO formationDAO= new FormationDAO();
		formationDAO.sauvegarder(formation);
		return  "/faces/index.xhtml";
	}
	
	public List<Formation> selectionner()
	{
		IFormationDAO  formationDAO = new FormationDAO();
		return formationDAO.selectionner();
	}
	
	//modifier un ordinateur
	public String modifier(int code)
	{
			IFormationDAO ordinateurDAO = new FormationDAO();
			Formation o = new Formation();
			o = ordinateurDAO.chercher(code);
			System.out.println("******************************************");
			System.out.println(o);

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("formation", o);
			return "/faces/modifierFormation.xhtml";
		}
	
	//actualiser les ordinateurs
	public String actualiser(Formation formation)
	{
		IFormationDAO formationDAO = new FormationDAO();
		formationDAO.modifier(formation);
		return "/faces/index.xhtml";
	}
	
	//supprimer un ordinateur
	public String supprimer(int code)
	{
		IFormationDAO formationDAO = new FormationDAO();
		formationDAO.supprimer(code);
		System.out.println("Ordinateur supprimé");
		return "/faces/index.xhtml";
	}
	
	
	
	
}
