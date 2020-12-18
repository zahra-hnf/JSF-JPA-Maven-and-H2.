package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.JPAUtil;
import com.ecodeup.model.Ordinateur;
import com.ecodeup.model.Salle;

public class SalleDAO implements ISalleDAO
{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void sauvegarder(Salle salle) {
		entity.getTransaction().begin();
		entity.persist(salle);
		entity.getTransaction().commit();
	}

	@Override
	public void modifier(Salle salle) {
		entity.getTransaction().begin();
		entity.merge(salle);
		entity.getTransaction().commit();
		
	}

	@Override
	public Salle chercher(int code) {
		Salle salle = new Salle();
		salle = entity.find(Salle.class, code);
		// JPAUtil.shutdown();
		return salle;
	}

	@Override
	public List<Salle> selectionner() {
		List<Salle> listeOrdinateur = new ArrayList<>();
		Query query = entity.createQuery("SELECT r FROM salle r");
		listeOrdinateur = query.getResultList();
		return listeOrdinateur;
	}

	@Override
	public void supprimer(int code) {
		Salle salle = new Salle();
		salle = entity.find(Salle.class, code);
		entity.getTransaction().begin();
		entity.remove(salle);
		entity.getTransaction().commit();
		
	}
	
}
