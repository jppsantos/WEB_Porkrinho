package br.com.porkrinho.controller.meta;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bo.MetaBO;
import br.com.porkrinho.controller.Logica;

public class CadastrarMeta implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MetaBO metaBO = new MetaBO();
		
		String titulo = request.getParameter("txtTitulo");
		String descricao = request.getParameter("txtDescricao");
		Double valor = Double.parseDouble(request.getParameter("txtValor"));
		boolean ehPublico = (request.getParameter("ehPublico").compareTo("on") == 0) ? true : false;
//		Date data = Date.valueOf(request.getParameter("txtData"));
		Date data = new java.util.Date();
		
		String resultado = metaBO.cadastrarMeta(0, titulo, descricao, valor, "", data, ehPublico);
		
		if (resultado == "TratarMeta/ListarMinhasMetas.jsp") {
			request.setAttribute("lista", new MetaBO().listarMinhasMetas(0));
		}else {
			request.setAttribute("erro", "Erro ao cadastrar meta.");
		}		
		return resultado;
	}

}