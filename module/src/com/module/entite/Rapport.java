package com.module.entite;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Rapport {
	private int id;
	
	private int auto_id;
	
	private String statut_fonctionnement;
	
	private String date_heure;
	
	private String etat;
	
	private int temperature;
	
	private String erreurs;
	
	private int montant_vente;
	
	private Systeme_paiement systeme_paiement;

	private List <Article> articles = new ArrayList<Article>();
	
	
	public Rapport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rapport(int auto_id, String num_serie_auto, String statut_fonctionnement, int montant_vente) {
		super();
		this.auto_id = auto_id;
		this.statut_fonctionnement = statut_fonctionnement;
		this.montant_vente = montant_vente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAuto_id() {
		return auto_id;
	}
	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}
	public String getStatut_fonctionnement() {
		return statut_fonctionnement;
	}
	public void setStatut_fonctionnement(String statut_fonctionnement) {
		this.statut_fonctionnement = statut_fonctionnement;
	}
	public int getMontant_vente() {
		return montant_vente;
	}
	public void setMontant_vente(int montant_vente) {
		this.montant_vente = montant_vente;
	}
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getErreurs() {
		return erreurs;
	}
	public void setErreurs(String erreurs) {
		this.erreurs = erreurs;
	}
	
	
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public Systeme_paiement getSysteme_paiement() {
		return systeme_paiement;
	}
	public void setSysteme_paiement(Systeme_paiement systeme_paiement) {
		this.systeme_paiement = systeme_paiement;
	}
	public String getDate_heure() {
		return date_heure;
	}
	public void setDate_heure(String date_heure) {
		this.date_heure = date_heure;
	}
	
	@Override
	public String toString() {
		return "Rapport [id=" + id + ", auto_id=" + auto_id + ", statut_fonctionnement=" + statut_fonctionnement
				+ ", date_heure=" + date_heure + ", etat=" + etat + ", temperature=" + temperature + ", erreurs="
				+ erreurs + ", montant_vente=" + montant_vente + ", systeme_paiement=" + systeme_paiement
				+ ", articles=" + articles + "]";
	}
	
}
