package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Installation;
import com.ecodeup.model.JPAUtil;


public class InstallationDAO implements IInstallationDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	@Override
	public void sauvegarder(Installation installation) {
		entity.getTransaction().begin();
		entity.persist(installation);
		entity.getTransaction().commit();
		
	}

	@Override
	public void modifier(Installation installation) {
		entity.getTransaction().begin();
		entity.merge(installation);
		entity.getTransaction().commit();
		
	}

	@Override
	public Installation chercher(int code) {
		Installation o = new Installation();
		o = entity.find(Installation.class, code);
		// JPAUtil.shutdown();
		return o;
	}

	@Override
	public List<Installation> selectionner() {
		List<Installation> listeInstallation = new ArrayList<>();
		Query query = entity.createQuery("select o from Installation o");
		listeInstallation = query.getResultList();
		return listeInstallation;
	}

	@Override
	public void supprimer(int code) {
		Installation installation = new Installation();
		installation = entity.find(Installation.class, code);
		entity.getTransaction().begin();
		entity.remove(installation);
		entity.getTransaction().commit();
		
	}

}
