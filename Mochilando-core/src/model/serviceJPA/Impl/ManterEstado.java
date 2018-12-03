package model.serviceJPA.Impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.daoJPA.impl.EstadoDAO;
import model.daoJPA.interfaces.InterfaceEstadoDAO;
import model.domainJPA.Estado;
import model.serviceJPA.interfaces.InterfaceManterEstado;
import util.db.exception.ExcecaoConexaoCliente;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author 
 */
public class ManterEstado implements InterfaceManterEstado{
    
    private final InterfaceEstadoDAO estadoDAO;

    public ManterEstado() {
        estadoDAO = new EstadoDAO();
    }

    
    @Override
    public Long cadastrar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if((estado.getNomEstado() == null) || (estado.getNomEstado().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o nome do estado.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar a sigla.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
        estadoDAO.inserir(estado);
        return estado.getCodEstado();
    }

    @Override
    public boolean alterar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if((estado.getNomEstado() == null) || (estado.getNomEstado().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar o nome do estado.");
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar a sigla.");
        
        estadoDAO.atualizar(estado);
        return true;
    }

    @Override
    public boolean excluir(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(estado != null){
            estadoDAO.deletar(estado);
        }
        return true;
    }

    @Override
    public Estado pesquisarPorId(Long codEstado) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return estadoDAO.consultarPorId(codEstado);
    }

    @Override
    public Estado pesquisarPorSigla(String sigla) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return estadoDAO.consultarPorSigla(sigla);
    }

    @Override
    public List<Estado> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        
        List<Estado> result = estadoDAO.listarTudo();
        return result;
    }
      
}
