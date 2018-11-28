/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.Dia;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceDiaDAO extends Remote{
    public Long inserir(Dia dia) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(Dia dia) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(Dia dia) throws ExcecaoPersistencia,RemoteException;
    public Dia consultarPorId(Long seqDia) throws ExcecaoPersistencia,RemoteException;
    public List<Dia> listarPorCodDiario(Long codDiario) throws ExcecaoPersistencia,RemoteException; 
    public List<Dia> listarTudo() throws ExcecaoPersistencia,RemoteException;
}
