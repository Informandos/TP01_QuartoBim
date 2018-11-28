/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.Comentario;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceComentarioDAO extends Remote{
    public Long inserir(Comentario comentario) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(Comentario comentario) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(Comentario comentario) throws ExcecaoPersistencia,RemoteException;
    public Comentario consultarPorId(Long seqComentario) throws ExcecaoPersistencia,RemoteException;
    public List<Comentario> listarPorCodDiario(Long codDiario) throws ExcecaoPersistencia,RemoteException;
    public List<Comentario> listarTudo() throws ExcecaoPersistencia,RemoteException;
}
