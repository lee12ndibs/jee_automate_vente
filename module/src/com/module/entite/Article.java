package com.module.entite;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Article {
	
	private int id;
	
	private String nom;
	
	private String description;
	
	private int quantite_restante;
	
	private int prix;
	
	private int quantite_vendue;
	
	private Rapport rapport;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantite_restante() {
		return quantite_restante;
	}
	public void setQuantite_restante(int quantite_restante) {
		this.quantite_restante = quantite_restante;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getQuantite_vendue() {
		return quantite_vendue;
	}
	public void setQuantite_vendue(int quantite_vendue) {
		this.quantite_vendue = quantite_vendue;
	}
	public Rapport getRapport() {
		return rapport;
	}
	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}
	@Override
	public String toString() {
		return "Article [nom=" + nom + ", prix=" + prix + "]";
	}
	
	
}
