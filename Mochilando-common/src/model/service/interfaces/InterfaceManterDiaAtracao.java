/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domain.DiaAtracao;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceManterDiaAtracao extends Remote {
    public Long cadastrar(DiaAtracao diaAtracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente , RemoteException;
    public boolean alterar(DiaAtracao diaAtracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public boolean excluir(DiaAtracao diaAtracao) throws ExcecaoPersistencia, ExcecaoNegocio,ExcecaoConexaoCliente, RemoteException;
    public DiaAtracao pesquisarPorId(Long seqDiaAtracao) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<DiaAtracao> pesquisarPorSeqDia(Long seqDia) throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
    public List<DiaAtracao> pesquisarTodos() throws ExcecaoPersistencia,ExcecaoConexaoCliente, RemoteException;
}
