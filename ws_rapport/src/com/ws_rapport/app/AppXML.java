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


@Path("/rapportXML")
public class AppXML {

	
	  
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response saveXMLRapport(Rapport rapport) {
	    RapportDAO.saveRapport(rapport);
	    return Response.ok().build();
	}
	
}