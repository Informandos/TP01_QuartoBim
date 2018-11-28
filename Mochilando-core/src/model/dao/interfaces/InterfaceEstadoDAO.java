/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainJPA.Estado;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceEstadoDAO extends Remote{
    public Long inserir(Estado estado) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(Estado estado) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(Estado estado) throws ExcecaoPersistencia,RemoteException;
    public Estado consultarPorId(Long codEstado) throws ExcecaoPersistencia,RemoteException;
    public Estado consultarPorSigla(String sigla) throws ExcecaoPersistencia,RemoteException;
    public List<Estado> listarTudo() throws ExcecaoPersistencia,RemoteException;
}
