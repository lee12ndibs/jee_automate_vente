package com.module.entite;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Systeme_paiement {
	
	
	private int id;
	
	private String monayeur;
	
	private String carte_a_puce;
	
	private String carte_sans_contact;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonayeur() {
		return monayeur;
	}
	public void setMonayeur(String monayeur) {
		this.monayeur = monayeur;
	}
	public String getCarte_a_puce() {
		return carte_a_puce;
	}
	public void setCarte_a_puce(String carte_a_puce) {
		this.carte_a_puce = carte_a_puce;
	}
	public String getCarte_sans_contact() {
		return carte_sans_contact;
	}
	public void setCarte_sans_contact(String carte_sans_contact) {
		this.carte_sans_contact = carte_sans_contact;
	}
	
	
	public Systeme_paiement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Systeme_paiement(String monayeur, String carte_a_puce, String carte_sans_contact) {
		super();
		this.monayeur = monayeur;
		this.carte_a_puce = carte_a_puce;
		this.carte_sans_contact = carte_sans_contact;
	}
	@Override
	public String toString() {
		return "Systeme_paiement [id=" + id + ", monayeur=" + monayeur + ", carte_a_puce=" + carte_a_puce
				+ ", carte_sans_contact=" + carte_sans_contact + "]";
	}
	
	
	
	
	
}
