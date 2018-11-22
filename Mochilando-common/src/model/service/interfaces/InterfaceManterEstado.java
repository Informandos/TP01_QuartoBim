/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.util.List;
import model.domain.Estado;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.rmi.Remote;   
import java.rmi.RemoteException;

/**
 *
 * @author Juliana, Carlos
 */
public interface InterfaceManterEstado extends Remote{
    public Long cadastrar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public Estado pesquisarPorId(Long codEstado) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public Estado pesquisarPorSigla(String sigla) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Estado> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
