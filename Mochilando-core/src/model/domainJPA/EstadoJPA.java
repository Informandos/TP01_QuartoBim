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
@Table(name="estado")
public class EstadoJPA implements Serializable{
    @Id
    @GeneratedValue
    private Long codEstado;
    
    private String nomEstado;
    private String siglaEstado;

    public Long getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Long codEstado) {
        this.codEstado = codEstado;
    }
        
}
