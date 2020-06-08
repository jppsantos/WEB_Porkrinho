package br.com.porkrinho.controller.meta;

import java.sql.Date;

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
		boolean ehPublico = Integer.parseInt(request.getParameter("ehPublico")) == 0 ? false : true;
		Date data = Date.valueOf(request.getParameter("txtData"));
		
		String resultado = metaBO.cadastraMeta(0, titulo, descricao, valor, "", data, ehPublico);
		
		if (resultado == "") {
			request.setAttribute("lista", new MetaBO().listarTodasMetas());
		}else {
			request.setAttribute("erro", "Erro ao cadastrar meta.");
		}		
		return resultado;
	}

}
