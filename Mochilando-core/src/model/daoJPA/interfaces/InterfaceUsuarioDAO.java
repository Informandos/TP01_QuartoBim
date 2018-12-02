package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.Usuario;

/**
 *
 * @author lucca
 */
public interface InterfaceUsuarioDAO {
    public Long inserir(Usuario usuario);
    public boolean atualizar(Usuario usuario);
    public boolean deletar(Usuario usuario);
    public Usuario consultarPorId(Long codUsuario);
    public Usuario consultarPorEmail(String txtEmail);
    public List<Usuario> listarTudo();
    public Usuario consultarPorEmailSenha(String email,String senha);
}
