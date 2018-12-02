package model.busca.implementacao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.dao.implementacao.UsuarioDAO;
import model.dao.interfaces.InterfaceUsuarioDAO;
<<<<<<< HEAD
import model.domainJPA.Diario;
=======
import model.domainAntigo.Diario;
import model.domainJPA.Usuario;
>>>>>>> a0b8329256d2b685c9365a099ddcd5dceb610043
import util.db.ConnectionManager;
import util.db.exception.ExcecaoPersistencia;

public class BuscarDiario {

    public List<Diario> buscaGeral(String busca) throws ExcecaoPersistencia {
        try {
            List<Diario> listaBuscaNome = compararNomDiario(busca);
            List<Diario> listaBuscaCidade = compararNomCidadeRelacionada(busca);
            List<Diario> listaBuscaTxtDiario = compararTextoDiario(busca);

            List<Diario> listaBuscaConjunta = new ArrayList();
            listaBuscaConjunta.addAll(listaBuscaNome);
            listaBuscaConjunta.addAll(listaBuscaCidade);
            listaBuscaConjunta.addAll(listaBuscaTxtDiario);

            return listaBuscaConjunta;
        } catch (ExcecaoPersistencia e) {
            throw new ExcecaoPersistencia(e.getMessage(), e);
        }
    }

    public List<Diario> compararNomDiario(String busca) throws ExcecaoPersistencia {

        String sql = "FROM diario WHERE nom_diario = " + busca;

        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios = em.createQuery(sql).getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;

    }

    public List<Diario> compararNomCidadeRelacionada(String busca) throws ExcecaoPersistencia {

        String sql = "SELECT * FROM diario d "
                + "JOIN usuario u ON d.cod_usuario = u.cod_usuario "
                + "JOIN cidade c ON u.cod_cidade = c.cidade WHERE c.nom_cidade = " + busca;
        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios = em.createQuery(sql).getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;

    }

    public List<Diario> compararTextoDiario(String busca) throws ExcecaoPersistencia {

        String sql = "SELECT * FROM diario WHERE txt_diario = ?";
        EntityManager em = new ConnectionFactory().getConnection();
        List<Diario> diarios = null;
        try {
            em.getTransaction().begin();
            diarios = em.createQuery(sql).getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return diarios;

    }

}
