package com.ecodeup.dao;

import java.util.List;

import com.ecodeup.model.Logiciel;

public interface ILogicielDAO 
{
	public void sauvegarder(Logiciel logiciel);
	public void modifier(Logiciel logiciel);
	public Logiciel chercher(int code);
	public List<Logiciel> selectionner();
	public void supprimer(int code);
}
