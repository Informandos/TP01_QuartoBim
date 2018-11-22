/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domain.Comentario;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceManterComentario extends Remote{
    public Long cadastrar(Comentario comentario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(Comentario comentario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(Comentario comentario) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public Comentario pesquisarPorId(Long seqComentario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Comentario> pesquisarPorCodDiario(Long codDiario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Comentario> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
