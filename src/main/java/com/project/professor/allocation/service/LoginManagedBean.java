package com.project.professor.allocation.service;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.project.professor.allocation.entity.Usuario;

@ManagedBean(value = "LoginMB")
@ViewScoped
public class LoginManagedBean {

	public LoginManagedBean() {
		// TODO Auto-generated constructor stub
	}

	private LoginService loginservice = new LoginService();
	private Usuario usuario = new Usuario();

	public String envia() {

		usuario = loginservice.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/main";
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
