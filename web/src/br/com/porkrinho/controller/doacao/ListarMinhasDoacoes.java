package br.com.porkrinho.controller.doacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bo.DoacaoBO;
import br.com.porkrinho.controller.Logica;

public class ListarMinhasDoacoes implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
		
		request.setAttribute("lista", new DoacaoBO().listarMinhasDoacoes(idUsuario));
		
		return "";
	}
	
}