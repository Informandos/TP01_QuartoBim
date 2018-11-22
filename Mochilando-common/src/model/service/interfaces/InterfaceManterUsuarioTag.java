/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.util.List;
import model.domain.UsuarioTag;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.rmi.Remote;   
import java.rmi.RemoteException; 

/**
 *
 * @author Juliana, Carlos
 */
public interface InterfaceManterUsuarioTag  extends Remote{
    public Long cadastrar(UsuarioTag usuarioTag) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(UsuarioTag usuarioTag) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(UsuarioTag usuarioTag) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public UsuarioTag pesquisarPorId(Long seqUsuarioTag) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<UsuarioTag> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<UsuarioTag> pesquisarPorCodUsuario(Long codUsuario) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<UsuarioTag> pesquisarPorCodTag(Long codTag) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
