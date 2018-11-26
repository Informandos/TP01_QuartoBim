package model.domainJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lucca
 */
@Entity
@Table(name = "foto", schema = "public")
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_foto")
    private Long seqFoto;

    //Ha muitas fotos para um mesmo dia
    @ManyToOne
    @JoinColumn(name = "seq_dia")
    private Dia dia;

    @Lob @Column(name = "foto")
    private Byte Foto;

    public Long getSeqFoto() {
        return seqFoto;
    }

    public void setSeqFoto(Long seqFoto) {
        this.seqFoto = seqFoto;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Byte getFoto() {
        return Foto;
    }

    public void setFoto(Byte Foto) {
        this.Foto = Foto;
    }

}
