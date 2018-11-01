/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domainJPA;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import model.domain.Usuario;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name="diario")
public class Diario {
    @Id
    @GeneratedValue
    private Long codDiario;
    
    private Usuario usuario;
    
    @Column(name = "nom_diario", nullable = true)
    private String nomDiario;
    private Date datPublicacao;
    private Date datInicioViagem;
    private Date datFimViagem;
    private String txtDiario;
    private String tipoDiario;

    public Long getCodDiario() {
        return codDiario;
    }

    public void setCodDiario(Long codDiario) {
        this.codDiario = codDiario;
    }
    
}
