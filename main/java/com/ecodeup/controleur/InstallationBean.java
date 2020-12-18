package com.ecodeup.controleur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.util.List;
import java.util.Map;
import com.ecodeup.model.*;
import com.ecodeup.dao.IInstallationDAO;
import com.ecodeup.dao.IOrdinateurDAO;
import com.ecodeup.dao.InstallationDAO;
import com.ecodeup.dao.OrdinateurDAO;
@ManagedBean(name="installationBean") 
@RequestScoped
public class InstallationBean 
{
	
	public String nouveau() {
		Installation i = new Installation();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("installation", i);
		return  "/faces/creerInstallation.xhtml";
	}
	
	public String sauvegarder(Installation installation) {
		
		IInstallationDAO installationDAO= new InstallationDAO();
		installationDAO.sauvegarder(installation);
		return  "/faces/index.xhtml";
	}
	
	public List<Installation> selectionner()
	{
		
		IInstallationDAO  installationDAO = new InstallationDAO();
		
		return installationDAO.selectionner();
	}
	

	public String modifier(int code)
	{
			IInstallationDAO installationDAO = new InstallationDAO();
			Installation i = new Installation();
			i = installationDAO.chercher(code);
			System.out.println("******************************************");
			System.out.println(i);

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("installation", i);
			return "/faces/modifierInstallation.xhtml";
		}

	public String actualiser(Installation installation)
	{
		IInstallationDAO installationDAO = new InstallationDAO();
		installationDAO.modifier(installation);
		return "/faces/index.xhtml";
	}
	

	public String supprimer(int code)
	{
		IInstallationDAO installationDAO = new InstallationDAO();
		installationDAO.supprimer(code);
		System.out.println("Installation supprimée");
		return "/faces/index.xhtml";
	}
	
	
	
	
}
