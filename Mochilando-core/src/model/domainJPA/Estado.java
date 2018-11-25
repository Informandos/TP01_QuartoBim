package model.domainJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lucca
 */

@Entity
@Table(name="estado", schema="public")
public class Estado implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codEstado;
    
    @Column(name = "nom_estado")
    private String nomEstado;
    @Column(name = "sigla")
    private String siglaEstado;
    
    public Estado(){
        
    }

    public Long getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Long codEstado) {
        this.codEstado = codEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    public String getSigla() {
        return siglaEstado;
    }

    public void setSigla(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }
        
}
