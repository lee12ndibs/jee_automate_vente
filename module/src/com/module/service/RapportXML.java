package com.module.service;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.module.entite.Rapport;

public abstract class RapportXML {
	 public static void createRapportXML(Rapport rapport) {
		 
	      try {
	 
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
	 
	        // élément de racine
	        Document doc = docBuilder.newDocument();
	        Element racine = doc.createElement("rapport");
	        doc.appendChild(racine);
	      
	 
	        // Numero de série
	        Element auto_id = doc.createElement("auto_id");
	        auto_id.appendChild(doc.createTextNode(String.valueOf(rapport.getAuto_id())));
	        racine.appendChild(auto_id);
	 
	        // l'emplacement
	        Element date_heure = doc.createElement("date_heure");
	        date_heure.appendChild(doc.createTextNode(rapport.getDate_heure()));
	        racine.appendChild(date_heure);
	 
	        
	        // Le statut_fonctionnement
	        Element statut_fonctionnement = doc.createElement("statut_fonctionnement");
	        statut_fonctionnement.appendChild(doc.createTextNode(rapport.getStatut_fonctionnement()));
	        racine.appendChild(statut_fonctionnement);
	        
	        // Les détails
	        Element details = doc.createElement("details");
	        racine.appendChild(details);
	        
	        // L'etat
	        Element etat = doc.createElement("etat");
	        etat.appendChild(doc.createTextNode(rapport.getEtat()));
	        details.appendChild(etat);
	        
	        // La température
	        Element temperature = doc.createElement("temperature");
	        temperature.appendChild(doc.createTextNode(String.valueOf(rapport.getTemperature())));
	        details.appendChild(temperature);
	        
	        // Les erreurrs
	        Element erreurs = doc.createElement("erreurs");
	        erreurs.appendChild(doc.createTextNode(rapport.getErreurs().toString()));
	        details.appendChild(erreurs);
	        
	        // Les systèmes de paiement
	        Element system_paiement = doc.createElement("system_paiement");
	        racine.appendChild(system_paiement);
	        
	        // La température
	        Element monayeur = doc.createElement("monayeur");
	        monayeur.appendChild(doc.createTextNode(rapport.getSysteme_paiement().getMonayeur()));
	        system_paiement.appendChild(monayeur);
	        
	        // La température
	        Element carte_a_puce = doc.createElement("carte_a_puce");
	        carte_a_puce.appendChild(doc.createTextNode(rapport.getSysteme_paiement().getCarte_a_puce()));
	        system_paiement.appendChild(carte_a_puce);
	        
	        // La température
	        Element carte_sans_contact = doc.createElement("carte_sans_contact");
	        carte_sans_contact.appendChild(doc.createTextNode(rapport.getSysteme_paiement().getCarte_sans_contact()));
	        system_paiement.appendChild(carte_sans_contact);
	        
	        //les articles
	        Element articles = doc.createElement("articles");
	        racine.appendChild(articles);
	        
	        for (int i = 0; i < rapport.getArticles().size(); i++) {
				Element article = doc.createElement("article");
				articles.appendChild(article);
				
				Element nom = doc.createElement("nom");
				nom.appendChild(doc.createTextNode(rapport.getArticles().get(i).getNom()));
				article.appendChild(nom);
				
				Element description = doc.createElement("description");
				description.appendChild(doc.createTextNode(rapport.getArticles().get(i).getDescription()));
				article.appendChild(description);
				
				Element quantite_rest = doc.createElement("quantite_restante");
				quantite_rest.appendChild(doc.createTextNode(String.valueOf(rapport.getArticles().get(i).getQuantite_restante())));
				article.appendChild(quantite_rest);
				
				Element quantite_vend = doc.createElement("quantite_vendue");
				quantite_vend.appendChild(doc.createTextNode(String.valueOf(rapport.getArticles().get(i).getQuantite_vendue())));
				article.appendChild(quantite_vend);
				
				Element prix = doc.createElement("prix");
				prix.appendChild(doc.createTextNode(String.valueOf(rapport.getArticles().get(i).getPrix())));
				article.appendChild(prix);
			}
	  
	        // Le montant des ventes
	        Element montant_vente = doc.createElement("montant_vente");
	        montant_vente.appendChild(doc.createTextNode(String.valueOf(rapport.getMontant_vente())));
	        racine.appendChild(montant_vente);
	        
	 
	        // write the content into xml file
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult resultat = new StreamResult(new File("rapport_"+String.valueOf(rapport.getAuto_id())) + "_" +rapport.getDate_heure()+".xml");
	 
	        transformer.transform(source, resultat);
	 
	        System.out.println("Fichier sauvegardé avec succès!");
	 
	     } catch (ParserConfigurationException pce) {
	         pce.printStackTrace();
	     } catch (TransformerException tfe) {
	         tfe.printStackTrace();
	     }
	  }

}
