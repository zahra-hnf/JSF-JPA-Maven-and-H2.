package com.ecodeup.controleur;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ecodeup.dao.ILogicielDAO;
import com.ecodeup.dao.LogicielDAO;
import com.ecodeup.model.Logiciel;


@ManagedBean(name="logicielBean") 
@RequestScoped
public class LogicielBean 
{

	public String nouveau() {
		Logiciel logiciel = new Logiciel();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("logiciel", logiciel);
		return  "/faces/creerLogiciel.xhtml";
	}

	public String sauvegarder(Logiciel logiciel) {
		ILogicielDAO logicielDAO= new LogicielDAO();
		logicielDAO.sauvegarder(logiciel);
		return  "/faces/index.xhtml";
	}

	public List<Logiciel> selectionner() {
		ILogicielDAO  logicielDAO = new LogicielDAO();
		return logicielDAO.selectionner();
	}


	public String modifier(int code) {
		ILogicielDAO logicielDAO = new LogicielDAO();
		Logiciel l = new Logiciel();
		l = logicielDAO.chercher(code);
		System.out.println("******************************************");
		System.out.println(l);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("logiciel", l);
		return "/faces/modifierLogiciel.xhtml";
	}


	public String actualiser(Logiciel logiciel) {
		ILogicielDAO logicielDAO = new LogicielDAO();
		logicielDAO.modifier(logiciel);
		return "/faces/index.xhtml";
	}

	public String supprimer(int code) {
		ILogicielDAO logicielDAO = new LogicielDAO();
		logicielDAO.supprimer(code);
		System.out.println("Salle supprimée");
		return "/faces/index.xhtml";
	}

}
