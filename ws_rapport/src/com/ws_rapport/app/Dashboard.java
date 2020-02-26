package com.ws_rapport.app;


import java.io.StringWriter;
import java.time.LocalDate;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ws_rapport.dao.AutomateDAO;
import com.ws_rapport.dao.RapportDAO;
import com.ws_rapport.entite.*;


@Path("/dashboard")
public class Dashboard {
 
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response getJSONRappport(@PathParam("id") int id) {
		Rapport rapport = RapportDAO.getRapport(id);
	    return Response.ok(rapport).header("Access-Control-Allow-Origin", "*").build();
	}
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRappport() {
		return Response.ok(RapportDAO.getAllRapport()).header("Access-Control-Allow-Origin", "*").build();
	}
	
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response saveJSONRapport(Rapport rapport) {
		RapportDAO.saveRapport(rapport);
		//System.out.println(rapport);
		return Response.ok().build();
	}
	
	
}