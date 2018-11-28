package model.dao.interfaces;

/**
 *
 * @author Juliana
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.domainAntigo.Atracao;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana
 */
public interface InterfaceAtracaoDAO extends Remote  {
    public Long inserir(Atracao atracao) throws ExcecaoPersistencia,RemoteException;
    public boolean atualizar(Atracao atracao) throws ExcecaoPersistencia,RemoteException;
    public boolean deletar(Atracao atracao) throws ExcecaoPersistencia,RemoteException;
    public Atracao consultarPorId(Long codAtracao) throws ExcecaoPersistencia,RemoteException;
    public List<Atracao> listarPorCodCidade(Long codCidade) throws ExcecaoPersistencia,RemoteException;
    public List<Atracao> listarPorCodEstado(Long codEstado) throws ExcecaoPersistencia,RemoteException;
    public List<Atracao> listarPorCodTipoAtracao(Long codTipoAtracao) throws ExcecaoPersistencia,RemoteException;
    public List<Atracao> listarTudo() throws ExcecaoPersistencia,RemoteException;
}
