/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceJPA.Impl;

import java.util.List;
import model.daoJPA.impl.DiaDAO;
import model.daoJPA.interfaces.InterfaceDiaDAO;
import model.domainJPA.Dia;
import model.serviceJPA.interfaces.InterfaceManterDia;
import util.db.exception.ExcecaoPersistencia;
import util.service.ExcecaoNegocio;

/**
 *
 * @author Juliana
 */
public class ManterDia implements InterfaceManterDia {

    private InterfaceDiaDAO diaDAO;

    public ManterDia() {
        diaDAO = new DiaDAO();
    }

    @Override
    public Long cadastrar(Dia dia) throws ExcecaoPersistencia, ExcecaoNegocio {
        if ((dia.getDiario().getCodDiario() == null)) {
            throw new ExcecaoNegocio("Obrigatório informar o codigo do diario ao qual o dia pertence");
        }

        if ((dia.getTxtDia() == null) || (dia.getTxtDia().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o texto do dia");
        }

        if (dia.getOrdemDia() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a ordem do dia");
        }

        if (dia.getDataDia() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a data do dia");
        }

        Long result = null;

        result = diaDAO.inserir(dia);

        return result;

    }

    @Override
    public boolean alterar(Dia dia) throws ExcecaoPersistencia, ExcecaoNegocio {
        if ((dia.getDiario().getCodDiario() == null)) {
            throw new ExcecaoNegocio("Obrigatório informar o codigo do diario ao qual o dia pertence");
        }

        if ((dia.getTxtDia() == null) || (dia.getTxtDia().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o texto do dia");
        }

        if (dia.getOrdemDia() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a ordem do dia");
        }

        if (dia.getDataDia() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a data do dia");
        }

        boolean result = false;

        result = diaDAO.atualizar(dia);

        return result;
    }

    @Override
    public boolean excluir(Dia dia) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;

        result = diaDAO.deletar(dia);

        return result;
    }

    @Override
    public Dia pesquisarPorId(Long seqDia) throws ExcecaoPersistencia {
        Dia result = null;

        result = diaDAO.consultarPorId(seqDia);

        return result;
    }

    @Override
    public List<Dia> pesquisarPorCodDiario(Long codDiario) throws ExcecaoPersistencia {
        List<Dia> result = null;

        result = diaDAO.listarPorCodDiario(codDiario);

        return result;
    }

    @Override
    public List<Dia> pesquisarTodos() throws ExcecaoPersistencia {
        List<Dia> result = null;

        result = diaDAO.listarTudo();

        return result;
    }
}
