/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.DiaAtracao;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */

public interface InterfaceDiaAtracaoDAO extends Remote{
    public Long inserir(DiaAtracao diaAtracao) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(DiaAtracao diaAtracao) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(DiaAtracao diaAtracao) throws ExcecaoPersistencia,RemoteException;
    public DiaAtracao consultarPorId(Long seqDiaAtracao) throws ExcecaoPersistencia,RemoteException;
    public List<DiaAtracao> listarPorSeqDia(Long seqDia) throws ExcecaoPersistencia,RemoteException;
    public List<DiaAtracao> listarTudo() throws ExcecaoPersistencia,RemoteException;
}
