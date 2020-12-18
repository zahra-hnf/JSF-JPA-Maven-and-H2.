package com.ecodeup.dao;

import java.util.List;

import com.ecodeup.model.Installation;

public interface IInstallationDAO 
{
	public void sauvegarder(Installation installation);
	public void modifier(Installation installation);
	public Installation chercher(int code);
	public List<Installation> selectionner();
	public void supprimer(int code);
}
