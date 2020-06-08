package br.com.porkrinho.controller.meta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bo.MetaBO;
import br.com.porkrinho.controller.Logica;

public class ListarMinhasMetas implements Logica{
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
						
		request.setAttribute("lista", new MetaBO().listarMinhasMetas(0));//===============id do usuario
		
		return "";
	}
}
