package model.service.implementacao;

import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.implementacao.DiaAtracaoDAO;
import model.dao.interfaces.InterfaceDiaAtracaoDAO;
import model.domainAntigo.DiaAtracao;
import model.service.interfaces.InterfaceManterDiaAtracao;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

public class ManterDiaAtracao implements InterfaceManterDiaAtracao{
    
    private final InterfaceDiaAtracaoDAO diaADAO;
    
    public ManterDiaAtracao() {
        diaADAO = new DiaAtracaoDAO();
    }
    
    @Override
    public Long cadastrar(DiaAtracao diaAtracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(diaAtracao.getSeqDiaAtracao() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do diaAtracao");
        }
        if(diaAtracao.getAtracao().getSeqAtracao() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da atração");
        }
        if(diaAtracao.getDia().getDataDia() == null){
            throw new ExcecaoNegocio("Obrigatório informar a data da atração");
        }
        
        Long result = null;
        try {
            result = diaADAO.inserir(diaAtracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiaAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean alterar(DiaAtracao diaAtracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(diaAtracao.getSeqDiaAtracao() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do diaAtracao");
        }
        if(diaAtracao.getAtracao().getSeqAtracao() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da atração");
        }
        if(diaAtracao.getDia().getDataDia() == null){
            throw new ExcecaoNegocio("Obrigatório informar a data da atração");
        }
        
        boolean result = false;
        try {
            result = diaADAO.atualizar(diaAtracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiaAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean excluir(DiaAtracao diaAtracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        try {
            result = diaADAO.deletar(diaAtracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiaAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public DiaAtracao pesquisarPorId(Long seqDiaAtracao) throws ExcecaoPersistencia {
        DiaAtracao result = null;
        try {
            result = diaADAO.consultarPorId(seqDiaAtracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiaAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<DiaAtracao> pesquisarPorSeqDia(Long seqDia) throws ExcecaoPersistencia {
        List<DiaAtracao> result = null;
        try {
            result = diaADAO.listarPorSeqDia(seqDia);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiaAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<DiaAtracao> pesquisarTodos() throws ExcecaoPersistencia {
        List<DiaAtracao> result = null;
        try {
            result = diaADAO.listarTudo();
        } catch (RemoteException ex) {
            Logger.getLogger(ManterDiaAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
