package model.daoJPA.implementacao;

import java.util.List;
import javax.persistence.EntityManager;
import model.domainJPA.TipoAtracao;
import model.daoJPA.interfaces.InterfaceTipoAtracaoDAO;

/**
 *
 * @author lucca
 */
public class TipoAtracaoDAO implements InterfaceTipoAtracaoDAO{

    @Override
    public Long inserir(TipoAtracao tipoAtracao) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(tipoAtracao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tipoAtracao.getCodTipoAtracao();
    }

    @Override
    public boolean atualizar(TipoAtracao tipoAtracao) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(tipoAtracao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(TipoAtracao tipoAtracao) {
        return true;
    }

    @Override
    public TipoAtracao consultarPorId(Long codTipoAtracao) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        TipoAtracao tipoAtracao = null;

        try {
            tipoAtracao = em.find(TipoAtracao.class, codTipoAtracao);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return tipoAtracao;
    }

    @Override
    public TipoAtracao consultarPorNome(String descTipoAtracao) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        TipoAtracao tipoAtrcao = null;
        try {
            em.getTransaction().begin();
            tipoAtrcao = (TipoAtracao) em.createQuery("SELECT * from public.tag where desc_tipo_atracao = " + descTipoAtracao).getSingleResult();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tipoAtrcao;
    }

    @Override
    public List<TipoAtracao> listarTudo() {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<TipoAtracao> tiposAtracao = null;
        try {
            em.getTransaction().begin();
            tiposAtracao = em.createQuery("SELECT * from public.tag").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return tiposAtracao;
    }
    
}
