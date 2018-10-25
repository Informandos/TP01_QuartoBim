package controller;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

@SessionScoped
@ManagedBean
public class CriarDiarioMB {
    private String titulo;
    private String tipoDiario;
    private Date dataInicio;
    private Date dataFim;
    private String detalhesViagem;
    private String detalhesDia;
    private UploadedFile midia;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoDiario() {
        return tipoDiario;
    }

    public void setTipoDiario(String tipoDiario) {
        this.tipoDiario = tipoDiario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDetalhesViagem() {
        return detalhesViagem;
    }

    public void setDetalhesViagem(String detalhesViagem) {
        this.detalhesViagem = detalhesViagem;
    }

    public String getDetalhesDia() {
        return detalhesDia;
    }

    public void setDetalhesDia(String detalhesDia) {
        this.detalhesDia = detalhesDia;
    }
    
    public UploadedFile getMidia() {
        return midia;
    }

    public void setMidia(UploadedFile midia) {
        this.midia = midia;
    }
    
    
}
