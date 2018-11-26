package model.daoJPA;

import java.util.List;
import model.domainAntigo.Foto;

/**
 *
 * @author lucca
 */
public interface InterfaceFotoDAO {
    public Long inserir(Foto foto);
    public boolean atualizar(Foto foto);
    public boolean deletar(Foto foto);
    public Foto consultarPorId(Long seqFoto);
    public List<Foto> listarTudo();
    public List<Foto> listarPorDia(Long seqDia);
}
