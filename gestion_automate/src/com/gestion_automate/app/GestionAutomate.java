package com.gestion_automate.app;

import java.io.IOException;

import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestion_automate.dao.*;
import com.gestion_automate.entite.*;

import java.util.*;

/**
 * Servlet implementation class App
 */
@WebServlet(urlPatterns="/automate/*", name="gestion_automate")
public class GestionAutomate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAutomate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action =   request.getPathInfo();

	//remettre dans un bloc try
		try {
			if(action != null) {
				 switch (action) {
				    case "/ajouter":
		                    ajouterAutomate(request, response);
				        break;
				    case "/supprimer":
		                    supprimerAutomate(request, response);
				        break;
				    case "/modifier":
		                   modifierAutomate(request, response);
				        break;
				    default:
				    		listeAutomate(request, response);
				        break;
				}
			}
			else {	 
				response.sendRedirect("automate/");
			}
	       
		} catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void listeAutomate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List < Automate > listeAutomate = AutomateDAO.getAllAutomate();
        request.setAttribute("listeAutomate", listeAutomate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/liste_automate.jsp");
        dispatcher.forward(request, response);
    }

	 private void ajouterAutomate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (request.getParameter("id") == null) {
		 	RequestDispatcher dispatcher = request.getRequestDispatcher("/ajouter_automate.jsp");
		 	dispatcher.forward(request, response);
		 }
		 else {
			Automate automate = new Automate();
			automate.setNum_serie(request.getParameter("num_serie"));
			automate.setType(request.getParameter("type"));
			automate.setAdresse_instal(request.getParameter("adresse_instal"));
			automate.setEmplacement(request.getParameter("emplacement"));
			automate.setLatitude(request.getParameter("longitude"));
			automate.setLongitude(request.getParameter("latitude"));
			automate.setDate_intervention(String.valueOf(LocalDate.now()));
			automate.setCommentaire(request.getParameter("commentaire"));
			AutomateDAO.saveAutomate(automate);
			response.sendRedirect("liste");
		 }
	 }
	 
	 private void modifierAutomate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	 	
	 	
	
		if (request.getParameter("update") == null) {
			int id = Integer.valueOf(request.getParameter("id"));
		 	Automate automate = AutomateDAO.getAutomate(id);
			automate.setNum_serie(automate.getNum_serie());
			automate.setAdresse_instal(automate.getAdresse_instal());
			automate.setType(request.getParameter("type"));
			automate.setEmplacement(automate.getEmplacement());
			automate.setLatitude(automate.getLatitude());
			automate.setLongitude(automate.getLongitude());
			automate.setDate_intervention(automate.getDate_intervention());
			automate.setCommentaire(automate.getCommentaire());
		 	request.setAttribute("automate", automate);
		 	RequestDispatcher dispatcher = request.getRequestDispatcher("/ajouter_automate.jsp");
		 	dispatcher.forward(request, response);
		 	
		 }
		 else {
			Automate automate = new Automate();
			automate.setId(Integer.valueOf(request.getParameter("id")));
			automate.setNum_serie(request.getParameter("num_serie"));
			automate.setAdresse_instal(request.getParameter("adresse_instal"));
			automate.setEmplacement(request.getParameter("emplacement"));
			automate.setType(request.getParameter("type"));
			automate.setLatitude(request.getParameter("longitude"));
			automate.setLongitude(request.getParameter("latitude"));
			automate.setDate_intervention(request.getParameter("date_intervention"));
			automate.setCommentaire(request.getParameter("commentaire"));
		
//			System.out.println(automate.toString());
			AutomateDAO.updateAutomate(automate);
			response.sendRedirect("liste");
		 }
	 }
	 
	 
	 private void supprimerAutomate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	        int id = Integer.valueOf(request.getParameter("id"));
	        AutomateDAO.deleteAutomate(id);
	        response.sendRedirect("liste");
	 }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
