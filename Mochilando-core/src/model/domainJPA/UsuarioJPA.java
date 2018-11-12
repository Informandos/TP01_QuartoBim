package model.domainJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author lucca
 */

@Entity
@Table(name="usuario")
public class UsuarioJPA implements Serializable{
    
    @Id
    @GeneratedValue
    private Long codUsuario;
    
    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String txtEmail;
    private String txtSenha;
    private Byte imgPerfil;
    private String sexo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dat_nascimento;
    private Long codCidade;

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }
    
}
