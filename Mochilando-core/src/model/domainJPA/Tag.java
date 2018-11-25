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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author lucca
 */
@Entity
@Table(name = "tag")
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codTag;

    @Column(name = "desc_tag")
    private String descTag;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tag_diario",
                joinColumns = {
                 @JoinColumn(name = "cod_diario")},
                inverseJoinColumns = {
                @JoinColumn(name = "cod_tag")})
    private List<Diario> diarios;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_tag",
                joinColumns = {
                 @JoinColumn(name = "cod_usuario")},
                inverseJoinColumns = {
                @JoinColumn(name = "cod_tag")})
    private List<Diario> usuarios;

    public Long getCodTag() {
        return codTag;
    }

    public void setCodTag(Long codTag) {
        this.codTag = codTag;
    }

    public List<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(List<Diario> diarios) {
        this.diarios = diarios;
    }

    public List<Diario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Diario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getDescTag() {
        return descTag;
    }

    public void setDescTag(String descTag) {
        this.descTag = descTag;
    }

}
