/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.util.List;
import model.domain.TipoAtracao;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.rmi.Remote;   
import java.rmi.RemoteException;

/**
 *
 * @author Juliana, Carlos
 */
public interface InterfaceManterTipoAtracao extends Remote{
    public Long cadastrar(TipoAtracao tipoAtracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(TipoAtracao tipoAtracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(TipoAtracao tipoAtracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public TipoAtracao pesquisarPorId(Long codTipoAtracao) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public TipoAtracao pesquisarPorNome(String descTipoAtracao) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<TipoAtracao> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
