package com.module.app;
import java.time.LocalDate;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.module.entite.Article;
import com.module.entite.Rapport;
import com.module.entite.Systeme_paiement;
import com.module.service.RapportJSON;
import com.module.service.RapportXML;


public class App {
	public static void main(String[] args) {

		
		System.out.println("test de génération de rapport au fichier JSON");
		Rapport rapport = new Rapport();
		rapport.setAuto_id(7);
		rapport.setStatut_fonctionnement("En service");
		rapport.setMontant_vente(150);
		rapport.setTemperature(12);
		rapport.setErreurs("pff");
		rapport.setEtat("ok");
		rapport.setDate_heure(String.valueOf(LocalDate.now()));
		rapport.setSysteme_paiement(new Systeme_paiement("normal", "normal", "erreur"));
		Article article = new Article();
		article.setNom("tic tac");
		article.setPrix(2);
		article.setQuantite_restante(3);
		article.setQuantite_vendue(2);
		rapport.getArticles().add(article);
		
		RapportXML.createRapportXML(rapport);
		Response response = RapportJSON.envoiJSON(rapport, "http://localhost:9090/ws_rapport/api", "rapportJSON");
		
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(Rapport.class));

		 
		
		
		
	}
}
