package model.daoJPA.implementacao;

import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceTagDiarioDAO;
import model.domainJPA.TagDiario;

/**
 *
 * @author lucca
 */
public class TagDiarioDAO implements InterfaceTagDiarioDAO{

    @Override
    public Long inserir(TagDiario tagDiario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(tagDiario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tagDiario.getCodDiarioTag();
    }

    @Override
    public boolean atualizar(TagDiario tagDiario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(tagDiario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(TagDiario tagDiario) {
        return true;
    }

    @Override
    public TagDiario consultarPorId(Long seqTagDiario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        TagDiario tagDiario = null;

        try {
            tagDiario = em.find(TagDiario.class, seqTagDiario);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return tagDiario;
    }

    @Override
    public List<TagDiario> listarTudo() {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<TagDiario> tagsDiario = null;
        try {
            em.getTransaction().begin();
            tagsDiario = em.createQuery("SELECT * from public.tag_diario").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tagsDiario;
    }

    @Override
    public List<TagDiario> listarPorCodDiario(Long codDiario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<TagDiario> tagsDiario = null;
        try {
            em.getTransaction().begin();
            tagsDiario = em.createQuery("SELECT * from public.tag_diario order by cod_diario").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tagsDiario;
    }

    @Override
    public List<TagDiario> listarPorCodTag(Long codTag) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<TagDiario> tagsDiario = null;
        try {
            em.getTransaction().begin();
            tagsDiario = em.createQuery("SELECT * from public.tag_diario order by cod_tag").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tagsDiario;
    }
    
}
