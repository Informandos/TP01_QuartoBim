package model.domainJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lucca
 */
@Entity
@Table(name="usuario_tag", schema="public")
public class UsuarioTag implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name = "seq_usuario_tag")
    private Long seqUsuarioTag;
    
    @ManyToOne
    @Column(name = "cod_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @Column(name = "cod_tag")
    private Tag tag;

    public Long getSeqUsuarioTag() {
        return seqUsuarioTag;
    }

    public void setSeqUsuarioTag(Long seqUsuarioTag) {
        this.seqUsuarioTag = seqUsuarioTag;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    
    
}
