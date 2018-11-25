/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domainJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name = "atracao", schema = "public")
public class Cidade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cidade")
    private Long codCidade;
    
    //Ha muitas cidades em um mesmo estado
    @ManyToOne
    @JoinColumn(name = "cod_estado")
    private Estado estado;
    
    @Column(name = "nom_cidade")
    private String nomCidade;

    public Cidade() {
    }

    public Cidade(Long codCidade, Estado estado, String nomCidade) {
        this.codCidade = codCidade;
        this.estado = estado;
        this.nomCidade = nomCidade;
    }

    public Long getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Long codCidade) {
        this.codCidade = codCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomCidade() {
        return nomCidade;
    }

    public void setNomCidade(String nomCidade) {
        this.nomCidade = nomCidade;
    }
    
}
