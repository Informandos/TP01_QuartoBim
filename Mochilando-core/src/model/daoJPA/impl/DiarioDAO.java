/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.impl;

import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import model.busca.implementacao.BuscarDiario;
import model.daoJPA.interfaces.InterfaceDiarioDAO;
import model.domainJPA.Diario;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public class DiarioDAO implements InterfaceDiarioDAO {

    @Override
    public Long inserir(Diario diario) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(diario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diario.getCodDiario();
    }

    @Override
    public boolean atualizar(Diario diario) {
       EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(diario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Diario diario) {
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.remove(diario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public Diario consultarPorId(Long codDiario) {
        EntityManager em = new ConnectionFactory().getConnection();

        Diario diario = null;

        try {
            diario = em.find(Diario.class, codDiario);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return diario;
    }

    @Override
    public List<Diario> listarTudo() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios =  em.createQuery("from public.diario ").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;
    }

    @Override
    public List<Diario> listarPorCodUsuario(Long codUsuario) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios =  em.createQuery("from public.diario WHERE cod_usuario = "+codUsuario).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;
    }

    @Override
    public List<Diario> listarPorCodCidade(Long codCidade) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios =  em.createQuery("from public.diario WHERE cod_cidade = "+codCidade).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;
    }

    @Override
    public List<Diario> listarPorCodEstado(Long codEstado) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios =  em.createQuery("from public.diario WHERE cod_estado = "+codEstado).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;
    }

    @Override
    public List<Diario> atualizarPaginaInicial(Long codUsuario) {
        String sql = "SELECT A.cod_diario FROM"
                    + " diario A JOIN tag_diario B ON A.cod_diario = B.cod_diario "
                    + "JOIN usuario_tag C ON B.cod_tag = C.cod_tag "
                    + "WHERE C.cod_usuario =  "+codUsuario
                    + "GROUP BY 1, A.dat_publicacao ORDER BY A.dat_publicacao";
        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios =  em.createQuery(sql).getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;
    }

    @Override
    public List<Diario> buscarDiario(String textoBusca) {
       List<Diario> diariosPesquisa = new ArrayList();
       BuscarDiario buscarDiario = new BuscarDiario();
        try {
            diariosPesquisa = buscarDiario.buscaGeral(textoBusca);
        } catch (ExcecaoPersistencia ex) {
            Logger.getLogger(DiarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return diariosPesquisa;
    }
    
}
