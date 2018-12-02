package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.UsuarioTag;

/**
 *
 * @author lucca
 */
public interface InterfaceUsuarioTagDAO {
    public Long inserir(UsuarioTag usuarioTag);
    public boolean atualizar(UsuarioTag usuarioTag);
    public boolean deletar(UsuarioTag usuarioTag);
    public UsuarioTag consultarPorId(Long seqUsuarioTag);
    public List<UsuarioTag> listarTudo();
    public List<UsuarioTag> listarPorCodUsuario(Long codUsuario);
    public List<UsuarioTag> listarPorCodTag(Long codTag);
}
