/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceJPA.Impl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.daoJPA.impl.DiarioDAO;
import model.daoJPA.interfaces.InterfaceDiarioDAO;
import model.domainJPA.Diario;
import model.serviceJPA.interfaces.InterfaceManterDiario;
import util.db.exception.ExcecaoConexaoCliente;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public class ManterDiario implements InterfaceManterDiario {
    
    private InterfaceDiarioDAO diarioDAO;
    
    public ManterDiario(){
        
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
        
            diarioDAO.inserir(diario);
        
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
        diarioDAO.atualizar(diario);
        return true;
    }

    @Override
    public boolean excluir(Diario diario) throws ExcecaoPersistencia, ExcecaoNegocio {
        
        if(diario != null){
            diarioDAO.deletar(diario);
        }
        return true; 
    }

    @Override
    public Diario pesquisarPorId(Long codDiario) throws ExcecaoPersistencia {
        Diario diario = null;
        diario = diarioDAO.consultarPorId(codDiario);
        return diario;
    }

    @Override
    public List<Diario> pesquisarTodos() throws ExcecaoPersistencia {
        List<Diario> result = null;
        result = diarioDAO.listarTudo();
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodUsuario(Long codUsuario) throws ExcecaoPersistencia {
        List<Diario> result = null;
        result = diarioDAO.listarPorCodUsuario(codUsuario);
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodCidade(Long codCidade) throws ExcecaoPersistencia {
        
        List<Diario> result = null;
        result = diarioDAO.listarPorCodCidade(codCidade);
        
        
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodEstado(Long codEstado) throws ExcecaoPersistencia {
        List<Diario> result = null;
        result = diarioDAO.listarPorCodEstado(codEstado);
        
        
        return result;
    }

    @Override
    public List<Diario> atualizarPagInicial(Long codUsuario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        List<Diario> result = null;
        
        result = diarioDAO.atualizarPaginaInicial(codUsuario);
        
        return result;
    }

    @Override
    public List<Diario> pesquisarDiario(String textoBusca) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        List<Diario> result = null;
        result = diarioDAO.buscarDiario(textoBusca);
        return result;
    }
    
}
