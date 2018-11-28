/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.AvaliacaoComentario;
import model.domainAntigo.Comentario;
import util.db.exception.ExcecaoPersistencia;


/**
 *
 * @author Juliana
 */
public interface InterfaceAvaliacaoComentarioDAO extends Remote {
    public Long inserir(AvaliacaoComentario avaliacaoComenario) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(AvaliacaoComentario avaliacaoComenario) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(AvaliacaoComentario avaliacaoComenario) throws ExcecaoPersistencia,RemoteException;
    public AvaliacaoComentario consultarPorId(Long seqAvaliacao) throws ExcecaoPersistencia,RemoteException;
    public int consultarNumAvPositivas(Long seqComentario) throws ExcecaoPersistencia,RemoteException;
    public int consultarNumAvNegativas(Long seqComentario) throws ExcecaoPersistencia,RemoteException;
    public List <AvaliacaoComentario> listarPorDiario(Long codDiario) throws ExcecaoPersistencia,RemoteException;
    public List <AvaliacaoComentario> listarTudo(Long seqAvaliacao) throws ExcecaoPersistencia,RemoteException;
}
