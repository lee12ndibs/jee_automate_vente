package com.gestion_automate.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gestion_automate.entite.*;
import com.gestion_automate.main.*;
import com.gestion_automate.util.*;

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
}