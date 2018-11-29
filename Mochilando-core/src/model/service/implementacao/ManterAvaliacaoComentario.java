package model.service.implementacao;

import java.rmi.RemoteException;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.implementacao.AvaliacaoComentarioDAO;
import model.dao.interfaces.InterfaceAvaliacaoComentarioDAO;
import model.domainAntigo.AvaliacaoComentario;
import model.domainAntigo.AvaliacaoDiario;
import model.service.interfaces.InterfaceManterAvaliacaoComentario;

public class ManterAvaliacaoComentario implements InterfaceManterAvaliacaoComentario{

    private final InterfaceAvaliacaoComentarioDAO aComntDAO;

    public ManterAvaliacaoComentario() {
        aComntDAO = new AvaliacaoComentarioDAO();
    }
    
    @Override
    public Long cadastrar(AvaliacaoComentario avaliacaoComentario) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (avaliacaoComentario.getSeqAvaliacao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código da avaliação");
        }
        if (avaliacaoComentario.getComentario().getSeqComentario() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do comentário");
        }
        if (avaliacaoComentario.getAvaliacao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a avaliação");
        }
        if (avaliacaoComentario.getUsuario().getCodUsuario() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do usuário");
        }
        
        Long result = null;
        try {
            result = aComntDAO.inserir(avaliacaoComentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean alterar(AvaliacaoComentario avaliacaoComentario) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (avaliacaoComentario.getSeqAvaliacao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código da avaliação");
        }
        if (avaliacaoComentario.getComentario().getSeqComentario() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do comentário");
        }
        if (avaliacaoComentario.getAvaliacao() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a avaliação");
        }
        if (avaliacaoComentario.getUsuario().getCodUsuario() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do usuário");
        }
        
        boolean result = false;
        try {
            result = aComntDAO.atualizar(avaliacaoComentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean excluir(AvaliacaoComentario avaliacaoComentario) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        try {
            result = aComntDAO.deletar(avaliacaoComentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public AvaliacaoComentario pesquisarPorId(Long seqAvaliacao) throws ExcecaoPersistencia {
        AvaliacaoComentario result = null;
        try {
            result = aComntDAO.consultarPorId(seqAvaliacao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int pesquisarNumAvPositivas(Long seqComentario) throws ExcecaoPersistencia {
        int result = 0;
        try {
            result = aComntDAO.consultarNumAvPositivas(seqComentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int pesquisarNumAvNegativas(Long seqComentario) throws ExcecaoPersistencia {
        int result = 0;
        try {
            result = aComntDAO.consultarNumAvNegativas(seqComentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<AvaliacaoComentario> pesquisarPorDiario(Long codDiario) throws ExcecaoPersistencia {
        List<AvaliacaoComentario> result = null;
        try {
            result = aComntDAO.listarPorDiario(codDiario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<AvaliacaoComentario> pesquisarTodos(Long seqAvaliacao) throws ExcecaoPersistencia {
        List<AvaliacaoComentario> result = null;
        try {
            result = aComntDAO.listarTudo(seqAvaliacao);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterAvaliacaoComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
   
}
