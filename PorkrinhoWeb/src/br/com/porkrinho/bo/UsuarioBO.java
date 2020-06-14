package br.com.porkrinho.bo;

import br.com.porkrinho.bean.UsuarioBean;
import br.com.porkrinho.dao.UsuarioDAO;

public class UsuarioBO {
	
	public boolean login(String email,String senha) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		return usuarioDao.login(email, senha);
	}

}
