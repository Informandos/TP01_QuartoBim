/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domainJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name="atracao", schema="public")
public class Atracao implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "seq_atracao")
    private Long seqAtracao;
    
    //Ha muitas atracoes para uma mesma cidade
    @ManyToOne
    @JoinColumn(name="cod_cidade")
    private Cidade cidade;
    
    //Ha muitas atracoes para um mesmo tipo de atracao
    @ManyToOne
    @Column(name = "tipo_atracao")
    private TipoAtracao tipoAtracao;
    
    @Column(name = "nom_atracao")
    private String nomAtracao;
    
    @Column(name = "nro_latitude")
    private Double nroLatitude;
    
    @Column(name = "nro_longitude")
    private Double nroLongitude;
    
    /*
    Dia e Atracao formam a tabela DiaAtracao
    Atracao e a dentetora do relacionamento, por isso
    recebe mappedBy=atracoes (List do tipo do dono do outro lado)
    no parametro ManyToMany
    */
    @ManyToMany(mappedBy="atracoes", cascade=CascadeType.ALL)
    private List<Dia> dias;

    public Atracao() {
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

    public List<Dia> getDias() {
        return dias;
    }

    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }

}
