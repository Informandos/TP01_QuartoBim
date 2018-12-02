package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.TipoAtracao;

/**
 *
 * @author lucca
 */
public interface InterfaceTipoAtracaoDAO {
    public Long inserir(TipoAtracao tipoAtracao);
    public boolean atualizar(TipoAtracao tipoAtracao);
    public boolean deletar(TipoAtracao tipoAtracao);
    public TipoAtracao consultarPorId(Long codTipoAtracao);
    public TipoAtracao consultarPorNome(String descTipoAtracao);
    public List<TipoAtracao> listarTudo();
}
