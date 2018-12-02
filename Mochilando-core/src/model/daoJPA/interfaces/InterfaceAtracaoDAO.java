/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoJPA.interfaces;

import java.util.List;
import model.domainJPA.Atracao;



/**
 *
 * @author Juliana
 */
public interface InterfaceAtracaoDAO {

    public Long inserir(Atracao atracao);

    public boolean atualizar(Atracao atracao);

    public boolean deletar(Atracao atracao);

    public Atracao consultarPorId(Long codAtracao);

    public List<Atracao> listarPorCodCidade(Long codCidade);

    public List<Atracao> listarPorCodEstado(Long codEstado);

    public List<Atracao> listarPorCodTipoAtracao(Long codTipoAtracao);

    public List<Atracao> listarTudo();
}
