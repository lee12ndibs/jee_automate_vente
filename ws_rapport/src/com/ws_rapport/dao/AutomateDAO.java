package com.ws_rapport.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ws_rapport.entite.*;
import com.ws_rapport.util.*;

/**
 * CRUD database operations
 * @author Kamo jude
 *
 */
public abstract class AutomateDAO {

    /**
     * Enregistrer automate
     * @param automate
     */
    public static void saveAutomate(Automate automate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(automate);
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
    public static void updateAutomate(Automate automate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(automate);
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
    public static void deleteAutomate(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Automate automate = session.get(Automate.class, id);
            if (automate != null) {
                session.delete(automate);
                System.out.println("automate is deleted");
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
    public static Automate getAutomate(int id) {

        Transaction transaction = null;
        Automate automate = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            automate = session.get(Automate.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return automate;
    }

    /**
     * Récupérer tous les automates
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List < Automate > getAllAutomate() {

        Transaction transaction = null;
        List < Automate > listOfAutomate = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfAutomate = session.createQuery("from Automate").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfAutomate;
    }
    
    public static List <Automate> getHorsServiceAutomate(){
    	Transaction transaction = null;
        List < Automate > listeAutomate= null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            Query query = session.createSQLQuery("select id, num_serie, adresse_instal, emplacement, date_intervention,  latitude, longitude, commentaire id_rapport from automate inner join (select max(id_rapport) as id_rapport, auto_id,statut_fonctionnement from rapport  group by auto_id, statut_fonctionnement) as rap on rap.auto_id = automate.id where lower(statut_fonctionnement) = :statut");
            query.setParameter("statut", "hors service");
            listeAutomate = query.getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listeAutomate;
    }
    
    public static Map<String,List<String>> getEnServiceAutomate(){
    	
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	Transaction transaction = null;
        List < Rapport > listeDeRapport= null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            Query query = session.createSQLQuery("select id, adresse_instal, commentaire, date_intervention, emplacement, num_serie, id_rapport  "
            		+ "from automate inner join rapport  on rapport.auto_id = automate.id where id_rapport "
            		+ "in (select id_rapport from (select max(id_rapport)  as id_rapport, auto_id from rapport group by auto_id) as rapport_max) "
            		+ "and lower(statut_fonctionnement) = :statut and lower(etat) = :etat");
            query.setParameter("statut", "en service");
            query.setParameter("etat", "ok");
            map.put("ok", query.getResultList());
            // commit transaction
            transaction.commit();
            
            // start a transaction
            session.beginTransaction();
            // get an user object
            query = session.createSQLQuery("select id, adresse_instal, commentaire, date_intervention, emplacement, num_serie, id_rapport  "
            		+ "from automate inner join rapport  on rapport.auto_id = automate.id where id_rapport "
            		+ "in (select id_rapport from (select max(id_rapport)  as id_rapport, auto_id from rapport group by auto_id) as rapport_max) "
            		+ "and lower(statut_fonctionnement) = :statut and lower(etat) = :etat");
            query.setParameter("statut", "en service");
            query.setParameter("etat", "erreur");
            map.put("erreur", query.getResultList());
            // commit transaction
            transaction.commit();
            
            // start a transaction
            session.beginTransaction();
            // get an user object
            query = session.createSQLQuery("select id, adresse_instal, commentaire, date_intervention, emplacement, num_serie, id_rapport  "
            		+ "from automate inner join rapport  on rapport.auto_id = automate.id where id_rapport "
            		+ "in (select id_rapport from (select max(id_rapport)  as id_rapport, auto_id from rapport group by auto_id) as rapport_max) "
            		+ "and lower(statut_fonctionnement) = :statut and lower(etat) = :etat");
            query.setParameter("statut", "en service");
            query.setParameter("etat", "attention");
            map.put("attention", query.getResultList());
            // commit transaction
            transaction.commit();
            
            // start a transaction
            session.beginTransaction();
            // get an user object
            query = session.createSQLQuery("select id, adresse_instal, commentaire, date_intervention, emplacement, num_serie, id_rapport  "
            		+ "from automate inner join rapport  on rapport.auto_id = automate.id where id_rapport "
            		+ "in (select id_rapport from (select max(id_rapport)  as id_rapport, auto_id from rapport group by auto_id) as rapport_max) "
            		+ "and lower(statut_fonctionnement) = :statut and lower(etat) = :etat");
            query.setParameter("statut", "en service");
            query.setParameter("etat", "alarme");
            map.put("alarme", query.getResultList());
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    	
    	return map;
    }
    
    public static List <Automate> getAReapprovisionnerAutomate(){
    	Transaction transaction = null;
        List < Automate > listeAutomate= new ArrayList<Automate>();
        List < Integer > listeIdAutomate = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            Query query = session.createSQLQuery("select distinct(id) from automate "
            		+ "inner join rapport on rapport.auto_id = automate.id "
            		+ "inner join article on article.rapport_id = rapport.id_rapport where id_rapport "
            		+ "in (select id_rapport from (select max(id_rapport)  as id_rapport, auto_id from rapport group by auto_id) as rapport_max) "
            		+ "and quantite_restante = :quantite_restante");
            query.setParameter("quantite_restante", 0);
            listeIdAutomate= query.getResultList();
            // commit transaction
            transaction.commit();
            
        
            //Récupération des automates a réapprovisionner
            for (int i = 0; i < listeIdAutomate.size(); i++) {
            	session.beginTransaction();
                // get an user object
            	listeAutomate.add(session.get(Automate.class, listeIdAutomate.get(i)));
                // commit transaction
                transaction.commit();
			}
            
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listeAutomate;
    }
    
    public static List <Automate> getVentesAutomate(){
    	Transaction transaction = null;
        List < Automate > listeAutomate= new ArrayList<Automate>();;
        List < Integer > listeIdAutomate = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            Query query = session.createSQLQuery("select id from (select distinct(id) as id, montant_vente "
            		+ "from automate "
            		+ "inner join rapport on rapport.auto_id = automate.id inner join article on article.rapport_id = rapport.id_rapport "
            		+ "where id_rapport in (select id_rapport from (select max(id_rapport)  as id_rapport, auto_id from rapport group by auto_id) as rapport_max) "
            		+ "order by rapport.montant_vente) as result;");
            listeIdAutomate = query.getResultList();
            transaction.commit();
            // commit transaction
            //Récupération des automates a réapprovisionner
            for (int i = 0; i < listeIdAutomate.size(); i++) {
            	session.beginTransaction();
                // get an user object
            	listeAutomate.add(session.get(Automate.class, listeIdAutomate.get(i)));
                // commit transaction
                transaction.commit();
			}
            // commit transaction
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listeAutomate;
    }
    
}