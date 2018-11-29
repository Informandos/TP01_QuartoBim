/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.implementacao;

import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.implementacao.DiarioDAO;
import model.dao.interfaces.InterfaceDiarioDAO;
import model.domainAntigo.Diario;
import model.service.interfaces.InterfaceManterDiario;
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
        diarioDAO = new DiarioDAO();
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
        Long result = null;
        try {
            result = diarioDAO.inserir(diario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
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
        boolean result = false;
        try {
            result = diarioDAO.atualizar(diario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean excluir(Diario diario) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        try {
            result = diarioDAO.deletar(diario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result; 
    }

    @Override
    public Diario pesquisarPorId(Long codDiario) throws ExcecaoPersistencia {
        Diario result = null;
        try {
            result = diarioDAO.consultarPorId(codDiario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Diario> pesquisarTodos() throws ExcecaoPersistencia {
        List<Diario> result = null;
        try {
            result = diarioDAO.listarTudo();
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodUsuario(Long codUsuario) throws ExcecaoPersistencia {
        List<Diario> result = null;
        try {
            result = diarioDAO.listarPorCodUsuario(codUsuario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodCidade(Long codCidade) throws ExcecaoPersistencia {
        List<Diario> result = null;
        try {
            result = diarioDAO.listarPorCodCidade(codCidade);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Diario> pesquisarPorCodEstado(Long codEstado) throws ExcecaoPersistencia {
        List<Diario> result = null;
        try {
            result = diarioDAO.listarPorCodCidade(codEstado);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Diario> atualizarPagInicial(Long codUsuario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        List<Diario> result = null;
        try {
            result = diarioDAO.atualizarPaginaInicial(codUsuario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Diario> pesquisarDiario(String textoBusca) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        List<Diario> result = null;
        try {
            result = diarioDAO.buscarDiario(textoBusca);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
