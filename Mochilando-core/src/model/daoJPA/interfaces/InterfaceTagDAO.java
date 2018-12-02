package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.Tag;

/**
 *
 * @author lucca
 */
public interface InterfaceTagDAO {
    public Long inserir(Tag tag);
    public boolean atualizar(Tag tag);
    public boolean deletar(Tag tag);
    public Tag consultarPorId(Long codTag);
    public Tag consultarPorNome(String descTag);
    public List<Tag> listarTudo();
}
