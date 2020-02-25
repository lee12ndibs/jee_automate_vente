package com.gestion_automate.main;

import java.time.LocalDate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestion_automate.dao.AutomateDAO;
import com.gestion_automate.entite.*;
import com.gestion_automate.util.*;

public class Main {
	public static void main(String[] args) {
		
		Automate A = new Automate("456789", String.valueOf(LocalDate.now()));
		A.setAdresse_instal("43 rue des sablons, 78245");
		A.setEmplacement("Sud");
		A.setCommentaire("Marque SSAuto");
		
		Transaction transaction = null;
		
		//dao.saveAutomate(A);
		//dao.deleteAutomate(3);
		//System.out.println(dao.getAllAutomate().toString());
		

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Automate > automates = session.createQuery("from Automate", Automate.class).list();
            automates.forEach(s -> System.out.println(s.toString()));
            session.close();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

}
