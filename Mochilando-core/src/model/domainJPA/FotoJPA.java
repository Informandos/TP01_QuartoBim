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
@Table(name="foto")
public class FotoJPA implements Serializable{
    
    @Id
    @GeneratedValue
    private Long seqFoto;
    
    private Long seqDia;
    private Byte Foto;

    public Long getSeqFoto() {
        return seqFoto;
    }

    public void setSeqFoto(Long seqFoto) {
        this.seqFoto = seqFoto;
    }
    
}
