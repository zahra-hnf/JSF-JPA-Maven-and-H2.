package com.ecodeup.dao;

import java.util.List;

import com.ecodeup.model.Salle;

public interface ISalleDAO  {
	public void sauvegarder(Salle salle);
	public void modifier(Salle Salle);
	public Salle chercher(int code);
	public List<Salle> selectionner();
	public void supprimer(int code);
}