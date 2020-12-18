package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logiciel")
public class Logiciel implements Serializable
{
	@Id
	@Column
	private int code_logiciel;
	

	public int getCode_logiciel() {
		return code_logiciel;
	}

	public void setCode_logiciel(int code_logiciel) {
		this.code_logiciel = code_logiciel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column
	private String nom;
	
	@Override
	public String toString() {
		return "Logiciel [code_logiciel=" + code_logiciel + ", nom=" + nom + "]";
	}
}
