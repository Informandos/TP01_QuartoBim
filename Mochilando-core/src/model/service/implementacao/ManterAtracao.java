package model.service.implementacao;

import java.rmi.RemoteException;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.implementacao.AtracaoDAO;
import model.dao.interfaces.InterfaceAtracaoDAO;
import model.domainAntigo.Atracao;
import model.service.interfaces.InterfaceManterAtracao;


public class ManterAtracao implements InterfaceManterAtracao {

    private final InterfaceAtracaoDAO atracaoDAO;

    public ManterAtracao() {
        atracaoDAO = new AtracaoDAO();
    }
    
    @Override
    public Long cadastrar(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(atracao.getSeqAtracao() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da atração");
        }
        if (atracao.getCidade().getCodCidade() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código da cidade onde se encontra a atração");
        }
        if (atracao.getTipoAtracao().getCodTipoAtracao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do tipo de atração");
        }
        if (atracao.getNomAtracao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o nome da atracao");
        }
        if (atracao.getNroLatitude() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a latitude da atracao");
        } else {
        }
        if (atracao.getNroLongitude() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a longitude da atracao");
        }
        
        Long result = null;
        try {
            result = atracaoDAO.inserir(atracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean alterar(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(atracao.getSeqAtracao() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da atração");
        }
        if (atracao.getCidade().getCodCidade() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código da cidade onde se encontra a atração");
        }
        if (atracao.getTipoAtracao().getCodTipoAtracao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do tipo de atração");
        }
        if (atracao.getNomAtracao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o nome da atracao");
        }
        if (atracao.getNroLatitude() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a latitude da atracao");
        }
        if (atracao.getNroLongitude() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a longitude da atracao");
        }
        
        boolean result = false;
        try {
            result = atracaoDAO.atualizar(atracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean excluir(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        try {
            result = atracaoDAO.deletar(atracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Atracao pesquisarPorId(Long id) throws ExcecaoPersistencia {
        Atracao result = null;
        try {
            result = atracaoDAO.consultarPorId(id);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Atracao> pesquisarPorCodEstado(Long codEstado) throws ExcecaoPersistencia {
        List<Atracao> result = null;
        try {
            result = atracaoDAO.listarPorCodEstado(codEstado);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Atracao> pesquisarPorCodTipoAtracao(Long codTipoAtracao) throws ExcecaoPersistencia {
        List<Atracao> result = null;
        try {
            result = atracaoDAO.listarPorCodTipoAtracao(codTipoAtracao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Atracao> pesquisarTodos() throws ExcecaoPersistencia {
        List<Atracao> result = null;
        try {
            result = atracaoDAO.listarTudo();
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Atracao> pesquisarPorCodCidade(Long codCidade) throws ExcecaoPersistencia {
        List<Atracao> result = null;
        try {
            result = atracaoDAO.listarPorCodCidade(codCidade);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAtracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
