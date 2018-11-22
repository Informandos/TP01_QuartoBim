
package model.service.interfaces;


import java.util.List;
import model.domain.Usuario;
import util.db.exception.*;
import java.rmi.Remote;   
import java.rmi.RemoteException;
/**
 *
 * @author Carlos
 */
public interface InterfaceManterUsuario extends Remote{
    public Long cadastrar(Usuario usuario) throws  ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente, RemoteException; 
    public boolean alterar(Usuario usuario) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(Usuario usuario) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente, RemoteException;
    public List<Usuario> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente,ExcecaoConexaoCliente, RemoteException;
    public Usuario pesquisarPorId(Long id) throws ExcecaoPersistencia,ExcecaoConexaoCliente,ExcecaoConexaoCliente, RemoteException;
    public Usuario getUserLogin(String email, String senha) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente, RemoteException;
     public Usuario getUserEmail(String email) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente, RemoteException;
}