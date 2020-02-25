package com.module.service;

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

public abstract class  RapportJSON {
	public static Response envoiJSON(Rapport rapport, String targetString, String pathString) {
		
	@SuppressWarnings("deprecation")
	Client client = ClientBuilder.newClient(new ClientConfig().register( LoggingFilter.class ) );
	WebTarget webTarget = client.target(targetString).path(pathString);
	
	Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
	Response response = invocationBuilder.post(Entity.entity(rapport, MediaType.APPLICATION_JSON));
	
	return response;
	}
}
