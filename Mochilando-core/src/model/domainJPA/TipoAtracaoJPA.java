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
@Table(name="tipo_atracao")
public class TipoAtracaoJPA implements Serializable{
    
    @Id
    @GeneratedValue
    private Long codTipoAtracao;
    
    private String descTipoAtracao;

    public Long getCodTipoAtracao() {
        return codTipoAtracao;
    }

    public void setCodTipoAtracao(Long codTipoAtracao) {
        this.codTipoAtracao = codTipoAtracao;
    }
    
}
