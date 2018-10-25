package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class LoginMB {
    
    private String email;
    private String senha;

    public String getUsuario() {
        return email;
    }

    public void setUsuario(String usuario) {
        this.email = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String fowardToRecuperacaoSenha(){
        return "recuperacaoSenha.jsf";
    }
    
}
