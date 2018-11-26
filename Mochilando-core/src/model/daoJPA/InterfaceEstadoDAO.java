/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA;

/**
 *
 * @author Juliana
 */

import java.util.List;
import model.domainJPA.Estado;

/**
 *
 * @author Juliana
 */
public interface InterfaceEstadoDAO {
    public Long inserir(Estado estado);
    public boolean atualizar(Estado estado);
    public boolean deletar(Estado estado);
    public Estado consultarPorId(Long codEstado);
    public Estado consultarPorSigla(String sigla);
    public List<Estado> listarTudo();
}
