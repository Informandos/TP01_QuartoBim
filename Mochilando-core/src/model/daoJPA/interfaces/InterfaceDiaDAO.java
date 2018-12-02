/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.Dia;

/**
 *
 * @author Juliana
 */
public interface InterfaceDiaDAO {
    public Long inserir(Dia dia);
    public boolean atualizar(Dia dia);
    public boolean deletar(Dia dia);
    public Dia consultarPorId(Long seqDia);
    public List<Dia> listarPorCodDiario(Long codDiario); 
    public List<Dia> listarTudo();

}
