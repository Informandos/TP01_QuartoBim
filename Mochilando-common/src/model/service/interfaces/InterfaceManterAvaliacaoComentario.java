/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domain.AvaliacaoComentario;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceManterAvaliacaoComentario extends Remote {

    
    public Long cadastrar(AvaliacaoComentario avaliacaoComentario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(AvaliacaoComentario avaliacaoComentario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(AvaliacaoComentario avaliacaoComentario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public AvaliacaoComentario pesquisarPorId(Long seqAvaliacao) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public int pesquisarNumAvPositivas(Long seqComentario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public int pesquisarNumAvNegativas(Long seqComentario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List <AvaliacaoComentario> pesquisarPorDiario(Long codDiario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List <AvaliacaoComentario> pesquisarTodos(Long seqAvaliacao) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
