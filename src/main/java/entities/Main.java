/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sebas
 */
public class Main {

    public static void main(String[] args) {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Movie m1 = new Movie("Star Wars", 1977, "George Lucas");
        Movie m2 = new Movie("Harry Potter", 2001, "J.K. Rowling");
        try {
            em.getTransaction().begin();
            em.persist(m1);
            em.persist(m2);
            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
            System.out.println(m1.getId());
            System.out.println(m2.getId());

        } finally {
            em.close();
        }
        */
    }
}
