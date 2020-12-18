package com.ecodeup.dao;

import java.util.List;

import com.ecodeup.model.Formation;

public interface IFormationDAO {
	public void sauvegarder(Formation formation);
	public void modifier(Formation formation);
	public Formation chercher(int code);
	public List<Formation> selectionner();
	public void supprimer(int code);
}
