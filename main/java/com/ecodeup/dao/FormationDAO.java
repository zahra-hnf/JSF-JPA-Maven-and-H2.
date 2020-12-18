package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Formation;
import com.ecodeup.model.JPAUtil;



public class FormationDAO implements IFormationDAO{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public void sauvegarder(Formation formation) {
		entity.getTransaction().begin();
		entity.persist(formation);
		entity.getTransaction().commit();
		
	}

	@Override
	public void modifier(Formation formation) {
		entity.getTransaction().begin();
		entity.merge(formation);
		entity.getTransaction().commit();
		
	}

	@Override
	public Formation chercher(int code) {
		Formation formation = new Formation();
		formation = entity.find(Formation.class, code);
		// JPAUtil.shutdown();
		return formation;
	}

	@Override
	public List<Formation> selectionner()
	{
		List<Formation> listeFormation = new ArrayList<>();
		Query query = entity.createQuery("select o from Formation o");
		listeFormation = query.getResultList();
		return listeFormation;
	}

	@Override
	public void supprimer(int code) {
		Formation formation = new Formation();
		formation = entity.find(Formation.class, code);
		entity.getTransaction().begin();
		entity.remove(formation);
		entity.getTransaction().commit();
		}

}
