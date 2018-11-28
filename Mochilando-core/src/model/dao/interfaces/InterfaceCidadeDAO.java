/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.Cidade;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceCidadeDAO extends Remote{
    public Long inserir(Cidade cidade) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(Cidade cidade) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(Cidade cidade) throws ExcecaoPersistencia,RemoteException;
    public Cidade consultarPorId(Long codCidade) throws ExcecaoPersistencia,RemoteException;
    public List<Cidade> listarPorCodEstado(Long codEstado) throws ExcecaoPersistencia,RemoteException;
    public List<Cidade> listarTudo() throws ExcecaoPersistencia,RemoteException;
}
