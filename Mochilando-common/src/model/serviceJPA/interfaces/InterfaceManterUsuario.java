
package model.serviceJPA.interfaces;


import util.db.exception.ExcecaoNegocio;
import java.util.List;
import model.domainJPA.Usuario;
import util.db.exception.*;

/**
 *
 * @author User
 */
public interface InterfaceManterUsuario {
    public Long cadastrar(Usuario usuario) throws  ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente; 
    public boolean alterar(Usuario usuario) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente;
    public boolean excluir(Usuario usuario) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente;
    public List<Usuario> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente,ExcecaoConexaoCliente;
    public Usuario pesquisarPorId(Long id) throws ExcecaoPersistencia,ExcecaoConexaoCliente,ExcecaoConexaoCliente;
    public Usuario getUserLogin(String email, String senha) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente;
     public Usuario getUserEmail(String email) throws ExcecaoPersistencia,ExcecaoNegocio,ExcecaoConexaoCliente,ExcecaoConexaoCliente;
}