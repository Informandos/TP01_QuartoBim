/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;


import util.db.exception.ExcecaoPersistencia;
import java.util.List;
import model.domain.Atracao;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import java.rmi.Remote;
import java.rmi.RemoteException;
/*
 *
 * @author Eduardo,Juiliana
 */
public interface InterfaceManterAtracao extends Remote  {
    
    public Long cadastrar(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean alterar(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public Atracao pesquisarPorId(Long id) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Atracao> pesquisarPorCodCidade(Long codCidade) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Atracao> pesquisarPorCodEstado(Long codEstado) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<Atracao> pesquisarPorCodTipoAtracao(Long codTipoAtracao) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;   
    public List<Atracao> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    
}
