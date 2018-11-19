/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceJPAImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.implementacao.DiarioDAO;
import model.dao.interfaces.InterfaceDiarioDAO;
import model.domain.Diario;
import model.service.interfaces.InterfaceManterDiario;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public class ManterDiario implements InterfaceManterDiario {
    
    private InterfaceDiarioDAO diarioDAO;
    protected EntityManager em;
    
    public ManterDiario(EntityManager em){
        this.em = em;
    }

    @Override
    public Long cadastrar(Diario diario) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(diario.getUsuario().getCodUsuario() == null ){
            throw new ExcecaoNegocio("Obrigatório informar o usuario proprietario do diario");
        }
        if(diario.getNomDiario() == null || diario.getNomDiario().isEmpty()){
            throw new ExcecaoNegocio("Obrigatório informar o nome (titulo) do diario");
        }
        if(diario.getDatPublicacao() == null){
            throw new ExcecaoNegocio("Obrigatório informar data de publicacao");
        }
        if(diario.getDatInicioViagem() == null){
            throw new ExcecaoNegocio("Obrigatório informar data de inicio da viagem");
        }
        if(diario.getDatFimViagem() == null){
            throw new ExcecaoNegocio("Obrigatório informar data de fim da viagem");
        }
        if(diario.getTxtDiario() == null || diario.getTxtDiario().isEmpty()){
            throw new ExcecaoNegocio("Obrigatório informar texto do diario");
        }
        if(diario.getTipoDiario() == null || diario.getTipoDiario().isEmpty()){
            throw new ExcecaoNegocio("Obrigatório informar tipo do diario");
        }
        em.persist(diario);
        return diario.getCodDiario();
    }

    @Override
    public boolean alterar(Diario diario) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(diario.getUsuario().getCodUsuario() == null ){
            throw new ExcecaoNegocio("Obrigatório informar o usuario proprietario do diario");
        }
        if(diario.getNomDiario() == null || diario.getNomDiario().isEmpty()){
            throw new ExcecaoNegocio("Obrigatório informar o nome (titulo) do diario");
        }
        if(diario.getDatPublicacao() == null){
            throw new ExcecaoNegocio("Obrigatório informar data de publicacao");
        }
        if(diario.getDatInicioViagem() == null){
            throw new ExcecaoNegocio("Obrigatório informar data de inicio da viagem");
        }
        if(diario.getDatFimViagem() == null){
            throw new ExcecaoNegocio("Obrigatório informar data de fim da viagem");
        }
        if(diario.getTxtDiario() == null || diario.getTxtDiario().isEmpty()){
            throw new ExcecaoNegocio("Obrigatório informar texto do diario");
        }
        Diario diarioAux = pesquisarPorId(diario.getCodDiario());
        if(diarioAux!=null){
            diarioAux.setDatFimViagem(diario.getDatFimViagem());
            diarioAux.setDatInicioViagem(diario.getDatFimViagem());
            diarioAux.setDatPublicacao(diario.getDatPublicacao());
            diarioAux.setNomDiario(diario.getNomDiario());
            diarioAux.setTipoDiario(diario.getTipoDiario());
            diarioAux.setTxtDiario(diario.getTxtDiario());
            diarioAux.setUsuario(diario.getUsuario());
        }
        return true;
    }

    @Override
    public boolean excluir(Diario diario) throws ExcecaoPersistencia, ExcecaoNegocio {
        
        if(diario != null){
            em.remove(diario);
        }
        return true; 
    }

    @Override
    public Diario pesquisarPorId(Long codDiario) throws ExcecaoPersistencia {
        
        return em.find(Diario.class, codDiario);
    }

    @Override
    public List<Diario> pesquisarTodos() throws ExcecaoPersistencia {
        Query query = em.createQuery("SELECT * FROM diario ORDER BY nom_diario");
        List<Diario> result = query.getResultList();
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodUsuario(Long codUsuario) throws ExcecaoPersistencia {
        Query query = em.createQuery("SELECT * FROM diario WHERE cod_usuario = "+ codUsuario +"ORDER BY nom_diario");
        List<Diario> result = query.getResultList();
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodCidade(Long codCidade) throws ExcecaoPersistencia {
        String sql = "SELECT A.* FROM diario A "
                    + "JOIN dia B ON A.cod_diario = B.cod_diario "
                    + "JOIN dia_atracao C ON B.seq_dia = C.seq_dia "
                    + "JOIN atracao D ON C.seq_atracao = D.seq_atracao "
                    + "JOIN cidade E ON D.cod_cidade_atracao = E.cod_cidade "
                    + "WHERE E.cod_cidade = "+codCidade +" "
                    + "GROUP BY 1 "
                    + "ORDER BY A.nom_diario;";
        Query query = em.createQuery(sql);
        List<Diario> result = query.getResultList();
        
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodEstado(Long codEstado) throws ExcecaoPersistencia {
        String sql = "SELECT A.* FROM diario A "
                    + "JOIN dia B ON A.cod_diario = B.cod_diario "
                    + "JOIN dia_atracao C ON B.seq_dia = C.seq_dia "
                    + "JOIN atracao D ON C.seq_atracao = D.seq_atracao "
                    + "JOIN cidade E ON D.cod_cidade_atracao = E.cod_cidade "
                    + "JOIN estado F ON E.cod_estado = F.cod_estado "
                    + "WHERE E.cod_estado = "+ codEstado +" "
                    + "GROUP BY 1;";
        Query query = em.createQuery(sql);
        List<Diario> result = query.getResultList();
        
        return result;
    }

    @Override
    public List<Diario> atualizarPagInicial(Long codUsuario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        String sql = "SELECT A.cod_diario FROM"
                    + " diario A JOIN tag_diario B ON A.cod_diario = B.cod_diario "
                    + "JOIN usuario_tag C ON B.cod_tag = C.cod_tag "
                    + "WHERE C.cod_usuario = ? "
                    + "GROUP BY 1, A.dat_publicacao ORDER BY A.dat_publicacao";
        
        Query query = em.createQuery(sql);
        List<Diario> result = query.getResultList();
        
        return result;
    }

    @Override
    public List<Diario> pesquisarDiario(String textoBusca) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        List<Diario> result = diarioDAO.buscarDiario(textoBusca);
        return result;
    }
    
}
