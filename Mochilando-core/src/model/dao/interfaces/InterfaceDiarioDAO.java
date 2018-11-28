/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.interfaces;

import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.Cidade;
import model.domainAntigo.Diario;
import model.domainAntigo.Estado;
import model.domainAntigo.Usuario;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceDiarioDAO {
    public Long inserir(Diario diario) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(Diario diario) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(Diario diario) throws ExcecaoPersistencia,RemoteException;
    public Diario consultarPorId(Long codDiario) throws ExcecaoPersistencia,RemoteException;
    public List<Diario> listarTudo() throws ExcecaoPersistencia,RemoteException;
    public List<Diario> listarPorCodUsuario(Long codUsuario) throws ExcecaoPersistencia,RemoteException;
    public List<Diario> listarPorCodCidade(Long codCidade) throws ExcecaoPersistencia,RemoteException;
    public List<Diario> listarPorCodEstado(Long codEstado) throws ExcecaoPersistencia,RemoteException;
    public List<Diario> atualizarPaginaInicial(Long codUsuario)throws ExcecaoPersistencia,RemoteException;
    public List<Diario> buscarDiario(String textoBusca) throws ExcecaoPersistencia,RemoteException;
}
