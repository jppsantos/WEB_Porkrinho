package br.com.porkrinho.controller.doacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bean.DoacaoBean;
import br.com.porkrinho.bean.MetaBean;
import br.com.porkrinho.bo.DoacaoBO;
import br.com.porkrinho.bo.MetaBO;
import br.com.porkrinho.controller.Logica;
import br.com.porkrinho.dao.DoacaoDAO;
import br.com.porkrinho.dao.MetaDAO;

public class AtualizarDoacao implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DoacaoBO doacaoBO = new DoacaoBO();
		int idDoacao = Integer.parseInt(request.getParameter("txtidDoacao"));
		Boolean ehAnonimo = Boolean.parseBoolean(request.getParameter("txtEhAnonimo"));
		Boolean	ehNotificado = Boolean.parseBoolean(request.getParameter("txtEhNotificado"));
		
		String resultado = "";
		
		//variaveis pra ser atualizadas
		resultado = doacaoBO.atualizarDoacao(idDoacao, ehAnonimo, ehNotificado);
		
		request.setAttribute("lista", new DoacaoDAO().listarTodasDoacoes());
		return resultado;	
	}

}

