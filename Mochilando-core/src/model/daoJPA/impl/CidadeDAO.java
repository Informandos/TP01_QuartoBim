/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.impl;

import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceCidadeDAO;
import model.domainJPA.Cidade;

/**
 *
 * @author Juliana
 */
public class CidadeDAO implements InterfaceCidadeDAO {

    @Override
    public Long inserir(Cidade cidade) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(cidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cidade.getCodCidade();
    }

    @Override
    public boolean atualizar(Cidade cidade) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(cidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Cidade cidade) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.remove(cidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public Cidade consultarPorId(Long codCidade) {
       EntityManager em = new ConnectionFactory().getConnection();

       Cidade cidade = null;
       
        try {
            cidade = em.find(Cidade.class, codCidade);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }

        return cidade;
    }

    @Override
    public List<Cidade> listarPorCodEstado(Long codEstado) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Cidade> cidades = null;
        try {
            em.getTransaction().begin();
            cidades = em.createQuery("from public.cidade where cod_estado = "+ codEstado).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cidades;
    }

    @Override
    public List<Cidade> listarTudo() {
       EntityManager em = new ConnectionFactory().getConnection();
        List<Cidade> cidades = null;
        try {
            em.getTransaction().begin();
            cidades = em.createQuery("from public.cidade").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cidades;
    }
    
}
