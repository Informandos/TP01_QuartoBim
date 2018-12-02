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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author lucca
 */
@Entity
@Table(name="tag_diario", schema="public")
public class TagDiario implements Serializable {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name = "cod_diario_tag")
    private Long codDiarioTag;
    
    @Column(name = "cod_diario")
    @ManyToOne
    private Diario diario;
    
    @Column(name = "cod_tag")
    @ManyToOne
    private Tag tag;

    public Long getCodDiarioTag() {
        return codDiarioTag;
    }

    public void setCodDiarioTag(Long codDiarioTag) {
        this.codDiarioTag = codDiarioTag;
    }

    public Diario getDiario() {
        return diario;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
    
}
