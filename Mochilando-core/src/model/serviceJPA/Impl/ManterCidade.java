/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceJPA.Impl;

import java.util.List;
import model.daoJPA.impl.CidadeDAO;
import model.daoJPA.interfaces.InterfaceCidadeDAO;
import model.domainJPA.Cidade;
import model.serviceJPA.interfaces.InterfaceManterCidade;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoPersistencia;
import util.service.ExcecaoNegocio;

/**
 *
 * @author Juliana
 */
public class ManterCidade implements InterfaceManterCidade {

    private final InterfaceCidadeDAO cidadeDAO;

    public ManterCidade() {
        cidadeDAO = new CidadeDAO();
    }

    @Override
    public Long cadastrar(Cidade cidade) throws ExcecaoPersistencia, ExcecaoNegocio {

        if (cidade.getEstado().getCodEstado() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do estado");
        }
        if (cidade.getNomCidade() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o nome da cidade");
        }

        Long result = null;

        result = cidadeDAO.inserir(cidade);

        return result;
    }

    @Override
    public boolean alterar(Cidade cidade) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (cidade.getCodCidade() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código da cidade");
        }
        if (cidade.getEstado().getCodEstado() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o código do estado");
        }
        if (cidade.getNomCidade() == null) {
            throw new ExcecaoNegocio("Obrigatório informar o nome da cidade");
        }

        boolean result = false;
        result = cidadeDAO.atualizar(cidade);

        return result;
    }

    @Override
    public boolean excluir(Cidade cidade) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;

        result = cidadeDAO.deletar(cidade);

        return result;
    }

    @Override
    public Cidade pesquisarPorId(Long codCidade) throws ExcecaoPersistencia {
        Cidade result = null;

        result = cidadeDAO.consultarPorId(codCidade);

        return result;
    }

    @Override
    public List<Cidade> pesquisarPorCodEstado(Long codEstado) throws ExcecaoPersistencia {
        List<Cidade> result = null;

        result = cidadeDAO.listarPorCodEstado(codEstado);

        return result;
    }

    @Override
    public List<Cidade> pesquisarTodos() throws ExcecaoPersistencia {
        List<Cidade> result = null;

        result = cidadeDAO.listarTudo();

        return result;
    }

}
