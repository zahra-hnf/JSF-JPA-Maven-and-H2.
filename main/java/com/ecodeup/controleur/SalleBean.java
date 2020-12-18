package com.ecodeup.controleur;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ecodeup.dao.ISalleDAO;
import com.ecodeup.dao.OrdinateurDAO;
import com.ecodeup.dao.SalleDAO;
import com.ecodeup.model.Ordinateur;
import com.ecodeup.model.Salle;


@ManagedBean(name="salleBean") 
@RequestScoped
public class SalleBean 
{

	public String nouveau() {
		Salle salle = new Salle();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("salle", salle);
		return  "/faces/creerSalle.xhtml";
	}

	public String sauvegarder(Salle salle) {
		ISalleDAO salleDAO= new SalleDAO();
		salleDAO.sauvegarder(salle);
		return  "/faces/index.xhtml";
	}

	public List<Salle> selectionner() {
		ISalleDAO  salleDAO = new SalleDAO();
		return salleDAO.selectionner();
	}


	public String modifier(int code) {
		ISalleDAO salleDAO = new SalleDAO();
		Salle s = new Salle();
		s = salleDAO.chercher(code);
		System.out.println("******************************************");
		System.out.println(s);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("salle", s);
		return "/faces/modifierSalle.xhtml";
	}


	public String actualiser(Salle salle) {
		ISalleDAO salleDAO = new SalleDAO();
		salleDAO.modifier(salle);
		return "/faces/index.xhtml";
	}

	public String supprimer(int code) {
		ISalleDAO salleDAO = new SalleDAO();
		salleDAO.supprimer(code);
		System.out.println("Salle supprimée");
		return "/faces/index.xhtml";
	}

}
