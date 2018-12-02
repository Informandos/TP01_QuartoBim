/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.Diario;

/**
 *
 * @author Juliana
 */
public interface InterfaceDiarioDAO {
    public Long inserir(Diario diario);
    public boolean atualizar(Diario diario);
    public boolean deletar(Diario diario);
    public Diario consultarPorId(Long codDiario);
    public List<Diario> listarTudo();
    public List<Diario> listarPorCodUsuario(Long codUsuario);
    public List<Diario> listarPorCodCidade(Long codCidade);
    public List<Diario> listarPorCodEstado(Long codEstado);
    public List<Diario> atualizarPaginaInicial(Long codUsuario);
    public List<Diario> buscarDiario(String textoBusca);
}
