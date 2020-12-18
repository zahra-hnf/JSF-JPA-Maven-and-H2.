package com.ecodeup.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="installation")
public class Installation 
{
	@Id
	@Column
	private int code_installation;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateinstall;
	@Column
	private String version;
	public int getCode_installation() {
		return code_installation;
	}
	public void setCode_installation(int code_installation) {
		this.code_installation = code_installation;
	}
	public Date getDateinstall() {
		return dateinstall;
	}
	public void setDateinstall(Date dateinstall) {
		this.dateinstall = dateinstall;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Installation [code_installation=" + code_installation + ", dateinstall=" + dateinstall + ", version="
				+ version + "]";
	}
	
	@Column(name="code_ordinateur")
	private int code_ordinateur;
	
	@ManyToOne
	@JoinColumn(name="code_ordinateur", referencedColumnName="code",insertable=false, updatable=false)
	private Ordinateur ordinateur;
	public int getCode_ordinateur() {
		return code_ordinateur;
	}
	public void setCode_ordinateur(int code_ordinateur) {
		this.code_ordinateur = code_ordinateur;
	}
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}
	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	
	@Column(name="code_logiciel")
	private int code_logiciel;
	
	@ManyToOne
	@JoinColumn(name="code_logiciel", referencedColumnName="code_logiciel",insertable=false, updatable=false)
	private Logiciel logiciel;
	
	public int getCode_logiciel() {
		return code_logiciel;
	}
	public void setCode_logiciel(int code_logiciel) {
		this.code_logiciel = code_logiciel;
	}
	public Logiciel getLogiciel() {
		return logiciel;
	}
	public void setLogiciel(Logiciel logiciel) {
		this.logiciel = logiciel;
	}

	
	
	
}
