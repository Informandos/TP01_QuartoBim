/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.util.List;
import model.domain.Foto;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.rmi.Remote;   
import java.rmi.RemoteException;

/**
 *
 * @author Juliana,Carlos
 */
public interface InterfaceManterFoto extends Remote{
    public Long cadastrar(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public Foto pesquisarPorId(Long seqFoto) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Foto> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Foto> pesquisarPorDia(Long seqDia) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
