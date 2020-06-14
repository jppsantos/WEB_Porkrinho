package br.com.porkrinho.controller.doacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bo.DoacaoBO;
import br.com.porkrinho.controller.Logica;

public class ListarTodasDoacoes implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int idMeta = Integer.parseInt(request.getParameter("txtIdMeta"));
		
		request.setAttribute("lista", new DoacaoBO().listarTodasDoacoes(idMeta));
		
		return "";
	}
}
