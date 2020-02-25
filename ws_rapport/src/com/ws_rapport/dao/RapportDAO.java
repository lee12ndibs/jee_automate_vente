package com.ws_rapport.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ws_rapport.entite.Article;
import com.ws_rapport.entite.Rapport;
import com.ws_rapport.util.*;

/**
 * CRUD database operations
 * @author Kamo jude
 *
 */
public abstract class RapportDAO {

    /**
     * Enregistrer automate
     * @param automate
     */
    public static void saveRapport(Rapport rapport) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            rapport.getArticles().size();
            session.save(rapport);
            // commit transaction
            transaction.commit();
         
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Modifier Automate
     * @param automate
     */
    public static void updateRapport(Rapport rapport) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(rapport);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Supprimer automate
     * @param id
     */
    public static void deleteRapport(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Rapport rapport = session.get(Rapport.class, id);
            if (rapport != null) {
                session.delete(rapport);
                System.out.println("rapport is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Récupére Automate par ID
     * @param id
     * @return
     */
    public static Rapport getRapport(int id) {

        Transaction transaction = null;
        Rapport rapport = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            rapport = session.get(Rapport.class, id);
           
            rapport.getArticles().size();
            
            //articles  = rapport.getArticles();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return rapport;
    }

    /**
     * Récupérer tous les automates
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List < Rapport > getAllRapport() {

        Transaction transaction = null;
        List < Rapport > listeDeRapport= null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listeDeRapport = session.createQuery("from Rapport").getResultList();
            for (int i = 0; i < listeDeRapport.size(); i++) {
				listeDeRapport.get(i).getArticles().size();
			}
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listeDeRapport;
    }
    
    
}