/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.util.List;
import model.domain.Tag;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.rmi.Remote;   
import java.rmi.RemoteException;

/**
 *
 * @author Juliana,Carlos
 */
public interface InterfaceManterTag extends Remote{
    public Long cadastrar(Tag tag) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(Tag tag) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(Tag tag) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public Tag pesquisarPorId(Long codTag) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public Tag pesquisarPorNome(String descTag) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Tag> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
