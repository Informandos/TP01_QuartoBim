/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.Cidade;

/**
 *
 * @author Juliana
 */
public interface InterfaceCidadeDAO {
    public Long inserir(Cidade cidade);
    public boolean atualizar(Cidade cidade) ;
    public boolean deletar(Cidade cidade);
    public Cidade consultarPorId(Long codCidade);
    public List<Cidade> listarPorCodEstado(Long codEstado);
    public List<Cidade> listarTudo();
}
