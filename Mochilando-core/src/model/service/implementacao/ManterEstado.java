/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.implementacao;

import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.implementacao.EstadoDAO;
import model.dao.interfaces.InterfaceEstadoDAO;
import model.domainJPA.Estado;
import model.service.interfaces.InterfaceManterEstado;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public class ManterEstado implements InterfaceManterEstado {
    
    private InterfaceEstadoDAO estadoDAO;
    
    public ManterEstado() {
        estadoDAO = new EstadoDAO();
    }

    @Override
    public Long cadastrar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio {
        if((estado.getNomEstado() == null) || (estado.getNomEstado().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar o nome do estado.");
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar a sigla.");
                  
        Long result = null;
        try {
            result = estadoDAO.inserir(estado);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean alterar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio {
        if((estado.getNomEstado() == null) || (estado.getNomEstado().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar o nome do estado.");
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar a sigla.");
                  
        boolean result = false;
        try {
            result = estadoDAO.atualizar(estado);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean excluir(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        try {
            result = estadoDAO.deletar(estado);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;   
    }

    @Override
    public Estado pesquisarPorId(Long codEstado) throws ExcecaoPersistencia {
        Estado result = null;
        try {
            result = estadoDAO.consultarPorId(codEstado);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Estado pesquisarPorSigla(String sigla) throws ExcecaoPersistencia {
       Estado result = null;
        try {
            result = estadoDAO.consultarPorSigla(sigla);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
       return result; 
    }

    @Override
    public List<Estado> pesquisarTodos() throws ExcecaoPersistencia {
        List<Estado> result = null;
        try {
            result = estadoDAO.listarTudo();
        } catch (RemoteException ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
