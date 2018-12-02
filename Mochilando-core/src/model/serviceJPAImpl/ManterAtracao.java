package model.serviceJPAImpl;

import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;
import java.util.List;
import model.daoJPA.interfaces.InterfaceAtracaoDAO;
import model.daoJPA.impl.AtracaoDAO;
import model.domainJPA.Atracao;

import model.service.interfaces.InterfaceManterAtracao;
import util.db.exception.ExcecaoConexaoCliente;

public class ManterAtracao implements InterfaceManterAtracao {

    private final InterfaceAtracaoDAO atracaoDAO;

    public ManterAtracao() {
        atracaoDAO = new AtracaoDAO();
    }

    @Override
    public Long cadastrar(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if (atracao.getSeqAtracao() == null) {
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
        result = atracaoDAO.inserir(atracao);
        return result;
    }

    @Override
    public boolean alterar(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (atracao.getSeqAtracao() == null) {
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
        result = atracaoDAO.atualizar(atracao);

        return result;
    }

    @Override
    public boolean excluir(Atracao atracao) throws ExcecaoPersistencia, ExcecaoNegocio {
        boolean result = false;
        if(atracao != null)
            result = atracaoDAO.deletar(atracao);
        
        return result;
    }

    @Override
    public Atracao pesquisarPorId(Long id) throws ExcecaoPersistencia {
        Atracao result = null;
        result = atracaoDAO.consultarPorId(id);
        return result;
    }

    @Override
    public List<Atracao> pesquisarPorCodEstado(Long codEstado) throws ExcecaoPersistencia {
        List<Atracao> result = null;
        result = atracaoDAO.listarPorCodEstado(codEstado);
        return result;
    }

    @Override
    public List<Atracao> pesquisarPorCodTipoAtracao(Long codTipoAtracao) throws ExcecaoPersistencia {
        List<Atracao> result = null;
        result = atracaoDAO.listarPorCodTipoAtracao(codTipoAtracao);
        return result;
    }

    @Override
    public List<Atracao> pesquisarTodos() throws ExcecaoPersistencia {
        List<Atracao> result = null;
        result = atracaoDAO.listarTudo();
        return result;
    }

    @Override
    public List<Atracao> pesquisarPorCodCidade(Long codCidade) throws ExcecaoPersistencia {
        List<Atracao> result = null;
        result = atracaoDAO.listarPorCodCidade(codCidade);
        return result;
    }

}
