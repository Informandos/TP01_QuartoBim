/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.impl;

import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceDiaDAO;
import model.domainJPA.Dia;

/**
 *
 * @author Juliana
 */
public class DiaDAO implements InterfaceDiaDAO{

    @Override
    public Long inserir(Dia dia) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(dia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return dia.getSeqDia();
    }

    @Override
    public boolean atualizar(Dia dia) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(dia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Dia dia) {
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.remove(dia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public Dia consultarPorId(Long seqDia) {
       EntityManager em = new ConnectionFactory().getConnection();

        Dia dia = null;

        try {
            dia = em.find(Dia.class, seqDia);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return dia;
    }

    @Override
    public List<Dia> listarPorCodDiario(Long codDiario) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Dia> dias = null;
        try {
            em.getTransaction().begin();
            dias =  em.createQuery("from public.dia where cod_diario = "+ codDiario).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return dias;
    }

    @Override
    public List<Dia> listarTudo() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Dia> dias = null;
        try {
            em.getTransaction().begin();
            
            dias =  em.createQuery("from public.dia").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return dias;
    }
    
}
