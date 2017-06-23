/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        final Cliente cliente = new Cliente(); 
        cliente.setId(1l);
        cliente.setNome("Carlos");

        em.persist(cliente);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
