package model.daoJPA.implementacao;

import java.util.List;
import javax.persistence.EntityManager;
import model.daoJPA.interfaces.InterfaceUsuarioDAO;
import model.domainJPA.Usuario;

/**
 *
 * @author lucca
 */
public class UsuarioDAO implements InterfaceUsuarioDAO{

    @Override
    public Long inserir(Usuario usuario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuario.getCodUsuario();
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean deletar(Usuario usuario) {
        return true;
    }

    @Override
    public Usuario consultarPorId(Long codUsuario) {
        EntityManager em = new connection.ConnectionFactory().getConnection();

        Usuario usuario = null;

        try {
            usuario = em.find(Usuario.class, codUsuario);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return usuario;
    }

    @Override
    public Usuario consultarPorEmail(String txtEmail) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        Usuario usuario = null;
        try {
            em.getTransaction().begin();
            usuario = (Usuario) em.createQuery("SELECT * from public.usuario where txt_email = " + txtEmail).getSingleResult();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuario;
    }

    @Override
    public List<Usuario> listarTudo() {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        List<Usuario> usuarios = null;
        try {
            em.getTransaction().begin();
            usuarios = em.createQuery("SELECT * from public.usuario").getResultList();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuarios;
    }

    @Override
    public Usuario consultarPorEmailSenha(String email, String senha) {
        EntityManager em = new connection.ConnectionFactory().getConnection();
        Usuario usuario = null;
        try {
            em.getTransaction().begin();
            usuario = (Usuario) em.createQuery("SELECT * from public.usuario where txt_email = " + email + "and txt_senha = " + senha).getSingleResult();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return usuario;
    }
    
}
