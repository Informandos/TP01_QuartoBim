/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.implementacao;

import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceEstadoDAO;
import model.domainJPA.Estado;

/**
 *
 *
 * @author Juliana
 */
public class EstadoDAO implements InterfaceEstadoDAO {

    @Override
    public Long inserir(Estado estado) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return estado.getCodEstado();
    }

    @Override
    public boolean atualizar(Estado estado) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(estado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Estado estado) {
        return true;
    }

    @Override
    public Estado consultarPorId(Long codEstado) {
        EntityManager em = new ConnectionFactory().getConnection();

        Estado estado = null;

        try {
            estado = em.find(Estado.class, codEstado);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return estado;
    }

    @Override
    public Estado consultarPorSigla(String sigla) {
        EntityManager em = new ConnectionFactory().getConnection();
        Estado estado = null;
        try {
            em.getTransaction().begin();
            estado = (Estado) em.createQuery("SELECT * from public.estado where sigla = "+ sigla).getSingleResult();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return estado;
    }

    @Override
    public List<Estado> listarTudo() {
        
        EntityManager em = new ConnectionFactory().getConnection();
        List<Estado> estados = null;
        try {
            em.getTransaction().begin();
            estados = em.createQuery("SELECT nom_estado, cod_estado from public.estado").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return estados;
    }

}
