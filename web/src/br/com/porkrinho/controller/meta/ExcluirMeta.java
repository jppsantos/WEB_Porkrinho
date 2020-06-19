package br.com.porkrinho.controller.meta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bo.MetaBO;
import br.com.porkrinho.controller.Logica;

public class ExcluirMeta implements Logica{
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MetaBO metaBO = new MetaBO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String resultado = metaBO.excluirMeta(id);
		
		if (resultado == "") {
			request.setAttribute("lista", new MetaBO().listarMinhasMetas(0));//id do usuario====================
		}else {
			request.setAttribute("erro", "Erro ao excluir meta.");
		}		
		return resultado;
	}
}
