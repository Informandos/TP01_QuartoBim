/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceJPA.Impl;

import java.util.List;
import model.daoJPA.impl.FotoDAO;
import model.daoJPA.interfaces.InterfaceFotoDAO;
import model.domainJPA.Foto;
import model.serviceJPA.interfaces.InterfaceManterFoto;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoPersistencia;
import util.service.ExcecaoNegocio;

/**
 *
 * @author Juliana
 */
public class ManterFoto implements InterfaceManterFoto {
    
    private InterfaceFotoDAO fotoDAO;
    public ManterFoto() {
        fotoDAO = new FotoDAO();
    }

    @Override
    public Long cadastrar(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if( (foto.getDia().getSeqDia()== null))
            throw new   ExcecaoNegocio("Obrigatório informar o codigo do dia ao qual a foto pertence");
        
        if( (foto.getSeqFoto()== null) )
            throw new   ExcecaoNegocio("Obrigatório informar o codigo da foto");
        
        if( foto.getFoto()==null)
            throw new ExcecaoNegocio("Obrigatório informar a foto");
         Long result = fotoDAO.inserir(foto);
         return result;
    }

    @Override
    public boolean alterar(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if( (foto.getDia().getSeqDia()== null))
            throw new   ExcecaoNegocio("Obrigatório informar o codigo do dia ao qual a foto pertence");
        
        if( (foto.getSeqFoto()== null) )
            throw new   ExcecaoNegocio("Obrigatório informar o codigo da foto");
        
        if( foto.getFoto()==null)
            throw new ExcecaoNegocio("Obrigatório informar a foto");
        boolean result = fotoDAO.atualizar(foto);
        return result;
    }

    @Override
    public boolean excluir(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        boolean result = fotoDAO.deletar(foto);
        return result; 
    }

    @Override
    public Foto pesquisarPorId(Long seqFoto) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        
        Foto result = fotoDAO.consultarPorId(seqFoto);
        return result;  
    }

    @Override
    public List<Foto> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        List<Foto> result = fotoDAO.listarTudo();
        return result;
    }

    @Override
    public List<Foto> pesquisarPorDia(Long seqDia) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
       List<Foto> result = fotoDAO.listarPorDia(seqDia);
       return result;
    }
    
}
