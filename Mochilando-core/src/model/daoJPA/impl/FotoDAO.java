package model.daoJPA.impl;

import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceFotoDAO;
import model.domainAntigo.Foto;

/**
 *
 * @author lucca
 */
public class FotoDAO implements InterfaceFotoDAO{

    @Override
    public Long inserir(Foto foto) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(foto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return foto.getSeqFoto();
    }

    @Override
    public boolean atualizar(Foto foto) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(foto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Foto foto) {
        return true;
    }

    @Override
    public Foto consultarPorId(Long seqFoto) {
        EntityManager em = new ConnectionFactory().getConnection();

        Foto foto = null;

        try {
            foto = em.find(Foto.class, seqFoto);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return foto;
    }

    @Override
    public List<Foto> listarTudo() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Foto> fotos = null;
        try {
            em.getTransaction().begin();
            fotos = em.createQuery("SELECT * from public.foto").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return fotos;
    }

    @Override
    public List<Foto> listarPorDia(Long seqDia) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Foto> fotos = null;
        try {
            em.getTransaction().begin();
            fotos = em.createQuery("SELECT * from public.foto order by seq_dia").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return fotos;
    }
    
}
