/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domainJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.serviceJPAImpl.ManterEstado;
import util.db.exception.ExcecaoConexaoCliente;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public class Teste {
    public static void main(String args[]) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente{
        
        
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("ManterEstado");
        EntityManager em = emf.createEntityManager();
        
        ManterEstado me = new ManterEstado(em);
        
        //Criando e persistindo um estado:
        em.getTransaction().begin();
        Estado e = new Estado();
        e.setSigla("PB");
        e.setNomEstado("Paraiba");
        me.cadastrar(e);
        em.getTransaction().commit();
        
    }
        
}
