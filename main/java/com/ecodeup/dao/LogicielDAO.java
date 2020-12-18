package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.JPAUtil;
import com.ecodeup.model.Logiciel;
import com.ecodeup.model.Salle;

public class LogicielDAO implements ILogicielDAO {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void sauvegarder(Logiciel logiciel) {
		entity.getTransaction().begin();
		entity.persist(logiciel);
		entity.getTransaction().commit();

	}

	@Override
	public void modifier(Logiciel logiciel) {
		entity.getTransaction().begin();
		entity.merge(logiciel);
		entity.getTransaction().commit();

	}

	@Override
	public Logiciel chercher(int code) {
		Logiciel logiciel = new Logiciel();
		logiciel = entity.find(Logiciel.class, code);
		// JPAUtil.shutdown();
		return logiciel;
	}

	@Override
	public List<Logiciel> selectionner() {
		List<Logiciel> listeLogiciel = new ArrayList<>();
		Query query = entity.createQuery("SELECT r FROM Logiciel r");
		listeLogiciel = query.getResultList();
		return listeLogiciel;
	}

	@Override
	public void supprimer(int code) {
		Logiciel logiciel = new Logiciel();
		logiciel = entity.find(Logiciel.class, code);
		entity.getTransaction().begin();
		entity.remove(logiciel);
		entity.getTransaction().commit();
		

	}

}
