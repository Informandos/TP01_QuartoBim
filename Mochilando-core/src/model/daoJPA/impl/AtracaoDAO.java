/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.impl;

import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceAtracaoDAO;
import model.domainJPA.Atracao;

/**
 *
 * @author Juliana
 */
public class AtracaoDAO implements InterfaceAtracaoDAO {

    @Override
    public Long inserir(Atracao atracao) {
       EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(atracao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return atracao.getSeqAtracao();
    }

    @Override
    public boolean atualizar(Atracao atracao) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(atracao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Atracao atracao) {
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.remove(atracao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public Atracao consultarPorId(Long codAtracao) {
        EntityManager em = new ConnectionFactory().getConnection();

        Atracao atracao = null;

        try {
            atracao = em.find(Atracao.class, codAtracao);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return atracao;
    }

    @Override
    public List<Atracao> listarPorCodCidade(Long codCidade) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Atracao> atracoes = null;
        try {
            em.getTransaction().begin();
            atracoes =  em.createQuery("from public.atracao where cod_cidade = "+ codCidade).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return atracoes;
    }

    @Override
    public List<Atracao> listarPorCodEstado(Long codEstado) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Atracao> atracoes = null;
        try {
            em.getTransaction().begin();
            atracoes =  em.createQuery("from public.atracao where cod_estado = "+ codEstado).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return atracoes;
    }

    @Override
    public List<Atracao> listarPorCodTipoAtracao(Long codTipoAtracao) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Atracao> atracoes = null;
        try {
            em.getTransaction().begin();
            atracoes =  em.createQuery("from public.atracao where cod_tipo_atracao = "+ codTipoAtracao).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return atracoes;
    }

    @Override
    public List<Atracao> listarTudo() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Atracao> atracoes = null;
        try {
            em.getTransaction().begin();
            atracoes =  em.createQuery("from public.atracao ").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return atracoes;
    }
    
}
