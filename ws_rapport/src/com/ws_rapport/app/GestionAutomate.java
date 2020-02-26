package com.ws_rapport.app;


import java.io.StringWriter;
import java.time.LocalDate;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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


@Path("/gestion_automate")
public class GestionAutomate {
 
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response getAutomate(@PathParam("id") int id) {
		Automate automate = AutomateDAO.getAutomate(id);
	    return Response.ok(automate).header("Access-Control-Allow-Origin", "*").build();
	}
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAutomate() {
		return Response.ok(AutomateDAO.getAllAutomate()).build();
	}
	
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response saveAutomate(Automate automate) {
		AutomateDAO.saveAutomate(automate);
		//System.out.println(rapport);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response deleteAutomate(@PathParam("id") int id) {
		AutomateDAO.deleteAutomate(id);
		//System.out.println(rapport);
		return Response.ok().build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Response updateAutomate(Automate automate) {
		AutomateDAO.updateAutomate(automate);
		//System.out.println(rapport);
		return Response.ok().build();
	}
}