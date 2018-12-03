package model.serviceJPA.Impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.daoJPA.impl.TagDAO;
import model.daoJPA.interfaces.InterfaceTagDAO;
import model.domainJPA.Tag;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterTag implements InterfaceTagDAO {

    protected InterfaceTagDAO tagDAO;

    public ManterTag() {
        tagDAO = new TagDAO();
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
        tagDAO.inserir(tag);
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
            tagDAO.deletar(tag);
        }
        return true;
    }

    @Override
    public Tag consultarPorId(Long codTag) {
        return tagDAO.consultarPorId(codTag);
    }

    @Override
    public Tag consultarPorNome(String descTag) {
        Tag result = tagDAO.consultarPorNome(descTag);
        return result;
    }

    @Override
    public List<Tag> listarTudo() {
        List<Tag> result = tagDAO.listarTudo();
        return result;
    }
    
}
