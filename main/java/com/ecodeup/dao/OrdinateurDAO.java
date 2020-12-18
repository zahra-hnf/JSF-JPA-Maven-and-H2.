package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import  javax.persistence.Query;
import com.ecodeup.model.JPAUtil;
import com.ecodeup.model.Ordinateur;

public class OrdinateurDAO implements IOrdinateurDAO
{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//créer un ordinateur
	public void sauvegarder(Ordinateur ordinateur) {
		entity.getTransaction().begin();
		entity.persist(ordinateur);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	//update ordinateur
	
	public void modifier(Ordinateur ordinateur)
	{
		entity.getTransaction().begin();
		entity.merge(ordinateur);
		entity.getTransaction().commit();
	//	JPAUtil.shutdown();
	}
	
	//chercher un ordinateur
	public Ordinateur chercher(int code)
	{
		Ordinateur o = new Ordinateur();
		o = entity.find(Ordinateur.class, code);
		// JPAUtil.shutdown();
		return o;
	}
		
	//read
	public List<Ordinateur> selectionner()
	{
		List<Ordinateur> listeOrdinateur = new ArrayList<>();
		Query query = entity.createQuery("select o from Ordinateur o");
		listeOrdinateur = query.getResultList();
		return listeOrdinateur;
	}
	
	
	/// eliminar cliente
		public void supprimer(int code) {
			Ordinateur ordinateur = new Ordinateur();
			ordinateur = entity.find(Ordinateur.class, code);
			entity.getTransaction().begin();
			entity.remove(ordinateur);
			entity.getTransaction().commit();
		}
	
}
