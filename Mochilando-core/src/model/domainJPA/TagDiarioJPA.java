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
@Table(name="tag_diario")
public class TagDiarioJPA implements Serializable{
    
    @Id
    @GeneratedValue
    private Long seqTagDiario;
    
    private Long tagDiario;
    private Long codTag;

    public Long getSeqTagDiario() {
        return seqTagDiario;
    }

    public void setSeqTagDiario(Long seqTagDiario) {
        this.seqTagDiario = seqTagDiario;
    }
    
}
