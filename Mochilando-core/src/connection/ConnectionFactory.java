/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Juliana
 */
public class ConnectionFactory {
    
    private static final String NOMEPU = "Mochilando-corePU";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(NOMEPU);
    private static EntityManager em;

   
    
    public EntityManager getConnection(){
        this.em = emf.createEntityManager();
        return em;
    }
}
