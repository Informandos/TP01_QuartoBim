/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domainJPA;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name="diario", schema="public")
public class Diario implements Serializable {
    
    @Id
    /* Identity significa id sequencial (chave burra)*/
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "cod_diario")
    private Long codDiario;
    /*
    * A anotação do relacionamento (unica) sera feita somente na
    * classe que tiver com o lado muitos -> convencao nossa
    * pEx: ha muitos diarios para o mesmo usuario. 
    * Logo, diario deve receber a notaçao ManyToOne
    * Sempre vai ter a @JoinColumn (unica tb e presente deste lado)
    */
    @ManyToOne
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;
    
    @Column(name = "nom_diario")
    private String nomDiario;
    
    @Column(name="dat_publicacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datPublicacao;
    
    @Column(name="dat_inicio_viagem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datInicioViagem;
    
    @Column(name="dat_fim_viagem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datFimViagem;
    
    @Column(name="txt_diario")
    @Lob @Basic(fetch=FetchType.LAZY)
    private String txtDiario;
    
    @Column(name="tipo_diario")
    private String tipoDiario;
    
    //diarios e o dono da relacao
    //entre diario e tag (diario_tag)
    @ManyToMany(mappedBy="diarios", cascade = CascadeType.ALL)
    private List<Tag> tags;

    public Long getCodDiario() {
        return codDiario;
    }

    public void setCodDiario(Long codDiario) {
        this.codDiario = codDiario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomDiario() {
        return nomDiario;
    }

    public void setNomDiario(String nomDiario) {
        this.nomDiario = nomDiario;
    }

    public Date getDatPublicacao() {
        return datPublicacao;
    }

    public void setDatPublicacao(Date datPublicacao) {
        this.datPublicacao = datPublicacao;
    }

    public Date getDatInicioViagem() {
        return datInicioViagem;
    }

    public void setDatInicioViagem(Date datInicioViagem) {
        this.datInicioViagem = datInicioViagem;
    }

    public Date getDatFimViagem() {
        return datFimViagem;
    }

    public void setDatFimViagem(Date datFimViagem) {
        this.datFimViagem = datFimViagem;
    }

    public String getTxtDiario() {
        return txtDiario;
    }

    public void setTxtDiario(String txtDiario) {
        this.txtDiario = txtDiario;
    }

    public String getTipoDiario() {
        return tipoDiario;
    }

    public void setTipoDiario(String tipoDiario) {
        this.tipoDiario = tipoDiario;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
}
