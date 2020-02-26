package com.gestion_automate.app;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet(urlPatterns = {"/dashboard/*"}, name="dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String action =   request.getPathInfo();
		System.out.println(request.getRequestURI());
		if(action != null) {
				switch (action) {
				    case "/hors_service":
				    		getDashboardHorsService(request, response);
				        break;
				    case "/en_service":
			    			getDashboardEnService(request, response);
				    	break;
				    case "/a_reapprovisionner":
		    				getDashboardAReapprovisinner(request, response);
		    			break;
				    case "/ventes":
	    					getDashboardVentes(request, response);
	    				break;
			    	
				    default:
				    		getDashboardEnService(request, response);
				        break;
			}
		}
		else {
			response.sendRedirect("dashboard/");
	        
		}
	}

	public void getDashboardEnService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/en_service.jsp");
        dispatcher.forward(request, response);
	}
	public void getDashboardHorsService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/hors_service.jsp");
        dispatcher.forward(request, response);
	}
	public void getDashboardAReapprovisinner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/a_reapprovisionner.jsp");
        dispatcher.forward(request, response);
	}
	public void getDashboardVentes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ventes.jsp");
        dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
