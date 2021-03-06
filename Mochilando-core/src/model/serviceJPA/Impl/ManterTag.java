package model.serviceJPA.Impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.daoJPA.interfaces.InterfaceTagDAO;
import model.domainJPA.Tag;
import model.serviceJPA.interfaces.InterfaceManterTag;
import util.db.exception.ExcecaoConexaoCliente;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterTag implements InterfaceTagDAO, InterfaceManterTag{

    protected EntityManager em;

    public ManterTag(){
        
    }
        
    public ManterTag(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Long inserir(Tag tag) {
        if((tag.getCodTag() == null))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o cod teg.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
         if((tag.getDescTag()== null) || (tag.getDescTag().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o desc tag.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.persist(tag);
        return tag.getCodTag();
    }

    @Override
    public boolean atualizar(Tag tag) {
        if((tag.getCodTag() == null))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o cod teg.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
         if((tag.getDescTag()== null) || (tag.getDescTag().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o desc tag.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Tag tagAux = consultarPorId(tag.getCodTag());
        
        if(tagAux != null){
            tagAux.setCodTag(tag.getCodTag());
            tagAux.setDescTag(tag.getDescTag());
        }
        return true;
        
    }

    @Override
    public boolean deletar(Tag tag) {
        if(tag != null){
            em.remove(tag);
        }
        return true;
    }

    @Override
    public Tag consultarPorId(Long codTag) {
        return em.find(Tag.class, codTag);
    }

    @Override
    public Tag consultarPorNome(String descTag) {
        Query query = em.createQuery("SELECT * FROM tag WHERE desc_tag = "+descTag);
        Tag result = (Tag) query.getSingleResult();
        return result;
    }

    @Override
    public List<Tag> listarTudo() {
        Query query = em.createQuery("SELECT * FROM tag ORDER BY cod_tag");
        List<Tag> result = query.getResultList();
        return result;
    }

    @Override
    public Long cadastrar(Tag tag) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Tag tag) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Tag tag) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tag pesquisarPorId(Long codTag) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tag pesquisarPorNome(String descTag) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tag> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
