/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name = "atracao", schema = "public")
public class Dia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_atracao")
    private Long seqDia;

    //Ha muitos dias em um mesmo diario
    @ManyToOne
    @JoinColumn(name = "cod_diario")
    private model.domainAntigo.Diario diario;

    @Column(name = "txt_dia")
    private String txtDia;

    @Column(name = "ordem_dia")
    private Integer ordemDia;

    @Column(name = "data_dia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDia;

    /*
    Como dia nao é detentora da relacao,
    sera a tabela inversa no join
    e devera relacionar ambas as tabelas
    dia e atracao na tabela de meio de campo dia_atracao
    */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dia_atracao",
            joinColumns = {
                @JoinColumn(name = "seq_atracao")},
            inverseJoinColumns = {
                @JoinColumn(name = "seq_dia")})
    private List<Atracao> atracoes;

    

    /**
     * @return the seqDia
     */
    public Long getSeqDia() {
        return seqDia;
    }

    /**
     * @param seqDia the seqDia to set
     */
    public void setSeqDia(Long seqDia) {
        this.seqDia = seqDia;
    }

    /**
     * @return the diario
     */
    public model.domainAntigo.Diario getDiario() {
        return diario;
    }

    /**
     * @param diario the diario to set
     */
    public void setDiario(model.domainAntigo.Diario diario) {
        this.diario = diario;
    }

    /**
     * @return the txtDia
     */
    public String getTxtDia() {
        return txtDia;
    }

    /**
     * @param txtDia the txtDia to set
     */
    public void setTxtDia(String txtDia) {
        this.txtDia = txtDia;
    }

    public Integer getOrdemDia() {
        return ordemDia;
    }

    public void setOrdemDia(Integer ordemDia) {
        this.ordemDia = ordemDia;
    }

    public Date getDataDia() {
        return dataDia;
    }

    public void setDataDia(Date dataDia) {
        this.dataDia = dataDia;
    }

    public List<Atracao> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(List<Atracao> atracoes) {
        this.atracoes = atracoes;
    }

}
