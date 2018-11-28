/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.AvaliacaoDiario;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceAvaliacaoDiarioDAO extends Remote{
    public Long inserir(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(AvaliacaoDiario avaliacaoDiario) throws ExcecaoPersistencia,RemoteException;
    public AvaliacaoDiario consultarPorId(Long seqAvaliacao) throws ExcecaoPersistencia,RemoteException;
    public int consultarNumAvPositivas(Long codDiario) throws ExcecaoPersistencia,RemoteException;
    public int consultarNumAvNegativas(Long codDiario) throws ExcecaoPersistencia,RemoteException;
    public List<AvaliacaoDiario> listarPorDiario(Long codDiario) throws ExcecaoPersistencia,RemoteException;
    public List<AvaliacaoDiario> listarTudo()throws ExcecaoPersistencia,RemoteException;
}
