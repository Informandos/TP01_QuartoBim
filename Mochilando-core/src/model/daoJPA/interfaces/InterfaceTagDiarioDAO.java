package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.TagDiario;

/**
 *
 * @author lucca
 */
public interface InterfaceTagDiarioDAO {
    public Long inserir(TagDiario tagDiario);
    public boolean atualizar(TagDiario tagDiario);
    public boolean deletar(TagDiario tagDiario);
    public TagDiario consultarPorId(Long seqTagDiario);
    public List<TagDiario> listarTudo();
    public List<TagDiario> listarPorCodDiario(Long codDiario);
    public List<TagDiario> listarPorCodTag(Long codTag);
}
