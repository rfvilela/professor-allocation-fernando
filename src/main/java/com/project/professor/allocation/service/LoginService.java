package com.project.professor.allocation.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.project.professor.allocation.entity.Usuario;

public class LoginService {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuarios");
	private EntityManager em = factory.createEntityManager();

	public Usuario getUsuario(String nomeUsuario, String senha) {

		      try {
		        Usuario usuario = (Usuario) em
		         .createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
		         .setParameter("name", nomeUsuario)
		         .setParameter("senha", senha).getSingleResult();

		        return usuario;
		      } catch (Exception e) {
		            return null;
		      }
		    }

	public boolean inserirUsuario(Usuario usuario) {
		try {
			em.persist(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUsuario(Usuario usuario) {
		try {
			em.remove(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
