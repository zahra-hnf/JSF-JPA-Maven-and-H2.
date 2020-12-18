package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="formation")
public class Formation implements Serializable
{

	@Id
	@Column
	private int code_formation;
	@Column
	private String nom;
	
	
	
	public int getCode_formation() {
		return code_formation;
	}


	public void setCode_formation(int code_formation) {
		this.code_formation = code_formation;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	/*public List<Salle> getSalles() {
		return salles;
	}


	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}*/

	@Override
	public String toString() {
		return "Formation [code_formation=" + code_formation + ", nom=" + nom + /*", salles=" + salles + */ "]";
	}

	
}
