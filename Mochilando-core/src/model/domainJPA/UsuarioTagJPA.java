package model.domainJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lucca
 */

@Entity
@Table(name="usuario_tag")
public class UsuarioTagJPA implements Serializable{
    
    @Id
    @GeneratedValue
    private Long seqUsuarioTag;
    
    private Long codUsuario;
    private Long codTag;

    public Long getSeqUsuarioTag() {
        return seqUsuarioTag;
    }

    public void setSeqUsuarioTag(Long seqUsuarioTag) {
        this.seqUsuarioTag = seqUsuarioTag;
    }

}
