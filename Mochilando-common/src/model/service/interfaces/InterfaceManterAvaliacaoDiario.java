/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domain.AvaliacaoDiario;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceManterAvaliacaoDiario extends Remote {
    
    public Long cadastrar(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public AvaliacaoDiario pesquisarPorId(Long seqAvaliacao) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public int pesquisarNumAvPositivas(Long codDiario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public int pesquisarNumAvNegativas(Long codDiario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<AvaliacaoDiario> pesquisarPorDiario(Long codDiario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<AvaliacaoDiario> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
