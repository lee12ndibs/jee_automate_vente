package com.ws_rapport.entite;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "article")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_article")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "quantite_restante")
	private int quantite_restante;
	
	@Column(name = "prix")
	private int prix;
	
	@Column(name = "quantite_vendue")
	private int quantite_vendue;
	
	@ManyToOne
    @JoinColumn(name = "rapport_id")
	@JsonBackReference
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
