package com.ecodeup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Ordinateur implements Serializable
{
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	@Column
	private String nom;
	@Column
	private String adresseIP;
	@Column
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresseIP() {
		return adresseIP;
	}
	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}
	@Override
	public String toString() {
		return "Ordinateur [code=" + code + ", nom=" + nom + ", adresseIP=" + adresseIP + ", getCode()=" + getCode()
				+ ", getNom()=" + getNom() + ", getadresseIP()=" + getAdresseIP() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	@Column(name="code_salle")
	private int code_salle;
	
	@ManyToOne
	@JoinColumn(name="code_salle", referencedColumnName="code_salle",insertable=false, updatable=false)
	private Salle salle;
	public int getCode_salle() {
		return code_salle;
	}
	public void setCode_salle(int code_salle) {
		this.code_salle = code_salle;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
	/*@OneToMany(targetEntity=Installation.class,mappedBy="ordinateur")
    private List<Installation> installation = new ArrayList<>();*/
}
