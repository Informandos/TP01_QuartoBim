package model.daoJPA.impl;

import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceTagDAO;
import model.domainJPA.Tag;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class TagDAO implements InterfaceTagDAO{
    
    @Override
    public Long inserir(Tag tag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(tag);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tag.getCodTag();
    }

    @Override
    public boolean atualizar(Tag tag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(tag);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Tag tag) {
      return true;  
    }

    @Override
    public Tag consultarPorId(Long codTag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        Tag tag = null;

        try {
            tag = em.find(Tag.class, codTag);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return tag;
    }

    @Override
    public Tag consultarPorNome(String descTag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        Tag tag = null;
        try {
            em.getTransaction().begin();
            tag = (Tag) em.createQuery("SELECT * from public.tag where desc_tag = " + descTag).getSingleResult();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tag;
    }

    @Override
    public List<Tag> listarTudo() {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<Tag> tags = null;
        try {
            em.getTransaction().begin();
            tags = em.createQuery("SELECT * from public.tag").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tags;
    }
    
}
