package model.service.implementacao;

import java.rmi.RemoteException;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.implementacao.ComentarioDAO;
import model.dao.interfaces.InterfaceComentarioDAO;
import model.domainAntigo.Comentario;
import model.service.interfaces.InterfaceManterComentario;

public class ManterComentario implements InterfaceManterComentario{
    
    private final InterfaceComentarioDAO comentarioDAO;

    public ManterComentario() {
        comentarioDAO = new ComentarioDAO();
    }
    
    @Override
    public Long cadastrar(Comentario comentario) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(comentario.getSeqComentario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do comentário");
        }
        if(comentario.getUsuario().getCodUsuario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do usuário");
        }
        if(comentario.getDiario().getCodDiario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do diário");
        }
        if(comentario.getDatPublicacao() == null){
            throw new ExcecaoNegocio("Obrigatório informar a data do comentario");
        }
        if(comentario.getTxtComentario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o comentário");
        }
        
        Long result = null;
        try {
            result = comentarioDAO.inserir(comentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean alterar(Comentario comentario) throws ExcecaoPersistencia, ExcecaoNegocio {
        if(comentario.getSeqComentario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do comentário");
        }
        if(comentario.getUsuario().getCodUsuario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do usuário");
        }
        if(comentario.getDiario().getCodDiario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do diário");
        }
        if(comentario.getDatPublicacao() == null){
            throw new ExcecaoNegocio("Obrigatório informar a data do comentario");
        }
        if(comentario.getTxtComentario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o comentário");
        }
        
        boolean result = false;
        try {
            result = comentarioDAO.atualizar(comentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean excluir(Comentario comentario) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        try {
            result = comentarioDAO.deletar(comentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Comentario pesquisarPorId(Long seqComentario) throws ExcecaoPersistencia {
        Comentario result = null;
        try {
            result = comentarioDAO.consultarPorId(seqComentario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Comentario> pesquisarPorCodDiario(Long codDiario) throws ExcecaoPersistencia {
        List<Comentario> result = null;
        try {
            result = comentarioDAO.listarPorCodDiario(codDiario);
        } catch (RemoteException ex) {
            Logger.getLogger(ManterComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Comentario> pesquisarTodos() throws ExcecaoPersistencia {
        List<Comentario> result = null;
        try {
            result = comentarioDAO.listarTudo();
        } catch (RemoteException ex) {
            Logger.getLogger(ManterComentario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
