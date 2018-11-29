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
import model.dao.implementacao.DiaDAO;
import model.dao.interfaces.InterfaceDiaDAO;
import model.domainAntigo.Dia;
import model.service.interfaces.InterfaceManterDia;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public class ManterDia implements InterfaceManterDia {
    
    private InterfaceDiaDAO diaDAO;
    
    public ManterDia(){
        diaDAO = new DiaDAO();
    }

    @Override
    public Long cadastrar(Dia dia) throws ExcecaoPersistencia, ExcecaoNegocio, NullPointerException {
        if( (dia.getDiario().getCodDiario() == null))
            throw new   ExcecaoNegocio("Obrigatório informar o codigo do diario ao qual o dia pertence");
        
        if( (dia.getTxtDia() == null) || (dia.getTxtDia().isEmpty()) )
            throw new   ExcecaoNegocio("Obrigatório informar o texto do dia");
        
        if( dia.getOrdemDia() == null)
            throw new ExcecaoNegocio("Obrigatório informar a ordem do dia");
        
        if( dia.getDataDia() == null)
            throw new ExcecaoNegocio("Obrigatório informar a data do dia");
        
        Long result = null;
        try {
            result = diaDAO.inserir(dia);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }

    @Override
    public boolean alterar(Dia dia) throws ExcecaoPersistencia, ExcecaoNegocio {
        if( (dia.getDiario().getCodDiario() == null))
            throw new   ExcecaoNegocio("Obrigatório informar o codigo do diario ao qual o dia pertence");
        
        if( (dia.getTxtDia() == null) || (dia.getTxtDia().isEmpty()) )
            throw new   ExcecaoNegocio("Obrigatório informar o texto do dia");
        
        if( dia.getOrdemDia() == null)
            throw new ExcecaoNegocio("Obrigatório informar a ordem do dia");
        
        if( dia.getDataDia() == null)
            throw new ExcecaoNegocio("Obrigatório informar a data do dia");
        
        boolean result = false;
        try {
            result = diaDAO.atualizar(dia);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean excluir(Dia dia) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        try {
            result = diaDAO.deletar(dia);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;    
    }

    @Override
    public Dia pesquisarPorId(Long seqDia) throws ExcecaoPersistencia {
        Dia result = null;
        try {
            result = diaDAO.consultarPorId(seqDia);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Dia> pesquisarPorCodDiario(Long codDiario) throws ExcecaoPersistencia {
        List<Dia> result = null;
        try {
            result = diaDAO.listarPorCodDiario(codDiario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Dia> pesquisarTodos() throws ExcecaoPersistencia {
        List<Dia> result = null;
        try {
            result = diaDAO.listarTudo();
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
