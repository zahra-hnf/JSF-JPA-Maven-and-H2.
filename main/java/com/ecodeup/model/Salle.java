package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.ArrayList;
@Entity(name="salle")
@Table
public class Salle  implements Serializable
{	
	@Id

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code_salle;
	
	@Override
	public String toString() {
		return "Salle [code_salle=" + code_salle + ", nom=" + nom + "]";
	}


	@Column
	private String nom;

	@Column
	public int getCODE_SALLE() {
		return code_salle;
	}

	public void setCODE_SALLE(int code_salle) {
		this.code_salle = code_salle;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	@OneToMany(targetEntity=Ordinateur.class,mappedBy="salle")
    private List<Ordinateur> ordinateurs = new ArrayList<>();
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable( name = "salle_formation",
                joinColumns = @JoinColumn( name = "code_salle" ),
                inverseJoinColumns = @JoinColumn( name = "code_formation" ) )
    private List<Formation> formations = new ArrayList<>();

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
}
