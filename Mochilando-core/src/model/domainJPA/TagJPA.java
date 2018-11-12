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
@Table(name="tag")
public class TagJPA implements Serializable{
    
    @Id
    @GeneratedValue
    private Long codTag;
    
    private String descTag;

    public Long getCodTag() {
        return codTag;
    }

    public void setCodTag(Long codTag) {
        this.codTag = codTag;
    }
    
}
