package com.ecodeup.dao;

import java.util.List;

import com.ecodeup.model.Ordinateur;

public interface IOrdinateurDAO  {
	public void sauvegarder(Ordinateur ordinateur);
	public void modifier(Ordinateur ordinateur);
	public Ordinateur chercher(int code);
	public List<Ordinateur> selectionner();
	public void supprimer(int code);
}
