package model.daoJPA.impl;

import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceUsuarioTagDAO;
import model.domainJPA.UsuarioTag;

/**
 *
 * @author lucca
 */
public class UsuarioTagDAO implements InterfaceUsuarioTagDAO{

    @Override
    public Long inserir(UsuarioTag usuarioTag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(usuarioTag);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuarioTag.getSeqUsuarioTag();
    }

    @Override
    public boolean atualizar(UsuarioTag usuarioTag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(usuarioTag);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(UsuarioTag usuarioTag) {
        return true;
    }

    @Override
    public UsuarioTag consultarPorId(Long seqUsuarioTag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        UsuarioTag usuarioTag = null;

        try {
            usuarioTag = em.find(UsuarioTag.class, seqUsuarioTag);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return usuarioTag;
    }

    @Override
    public List<UsuarioTag> listarTudo() {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<UsuarioTag> usuarioTags = null;
        try {
            em.getTransaction().begin();
            usuarioTags = em.createQuery("SELECT * from public.usuario_tag").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuarioTags;
    }

    @Override
    public List<UsuarioTag> listarPorCodUsuario(Long codUsuario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<UsuarioTag> usuarioTags = null;
        try {
            em.getTransaction().begin();
            usuarioTags = em.createQuery("SELECT * from public.usuario_tag order by cod_usuario").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuarioTags;
    }

    @Override
    public List<UsuarioTag> listarPorCodTag(Long codTag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<UsuarioTag> usuarioTags = null;
        try {
            em.getTransaction().begin();
            usuarioTags = em.createQuery("SELECT * from public.usuario_tag order by cod_tag").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuarioTags;
    }
    
}
