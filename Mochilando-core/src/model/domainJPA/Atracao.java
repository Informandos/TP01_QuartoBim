/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domainJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import model.domain.*;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name="atracao", schema="public")
public class Atracao implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long seqAtracao;
    
    private Cidade cidade;
    private TipoAtracao tipoAtracao;
    private String nomAtracao;
    private Double nroLatitude;
    private Double nroLongitude;

    public Atracao() {
    }

    public Atracao(Long seqAtracao, Cidade cidade, TipoAtracao tipoAtracao, String nomAtracao, double nroLatitude, double nroLongitude) {
        this.seqAtracao = seqAtracao;
        this.cidade = cidade;
        this.tipoAtracao = tipoAtracao;
        this.nomAtracao = nomAtracao;
        this.nroLatitude = nroLatitude;
        this.nroLongitude = nroLongitude;
    }

    /**
     * @return the seqAtracao
     */
    public Long getSeqAtracao() {
        return seqAtracao;
    }

    /**
     * @param seqAtracao the seqAtracao to set
     */
    public void setSeqAtracao(Long seqAtracao) {
        this.seqAtracao = seqAtracao;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the tipoAtracao
     */
    public TipoAtracao getTipoAtracao() {
        return tipoAtracao;
    }

    /**
     * @param tipoAtracao the tipoAtracao to set
     */
    public void setTipoAtracao(TipoAtracao tipoAtracao) {
        this.tipoAtracao = tipoAtracao;
    }

    /**
     * @return the nomAtracao
     */
    public String getNomAtracao() {
        return nomAtracao;
    }

    /**
     * @param nomAtracao the nomAtracao to set
     */
    public void setNomAtracao(String nomAtracao) {
        this.nomAtracao = nomAtracao;
    }

    /**
     * @return the nroLatitude
     */
    public Double getNroLatitude() {
        return nroLatitude;
    }

    /**
     * @param nroLatitude the nroLatitude to set
     */
    public void setNroLatitude(Double nroLatitude) {
        this.nroLatitude = nroLatitude;
    }

    /**
     * @return the nroLongitude
     */
    public Double getNroLongitude() {
        return nroLongitude;
    }

    /**
     * @param nroLongitude the nroLongitude to set
     */
    public void setNroLongitude(Double nroLongitude) {
        this.nroLongitude = nroLongitude;
    }

}
