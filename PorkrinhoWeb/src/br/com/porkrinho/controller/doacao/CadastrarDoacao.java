package br.com.porkrinho.controller.doacao;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bean.MetaBean;
import br.com.porkrinho.bo.DoacaoBO;
import br.com.porkrinho.bo.MetaBO;
import br.com.porkrinho.controller.Logica;
import br.com.porkrinho.dao.MetaDAO;

public class CadastrarDoacao implements Logica {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DoacaoBO doacaoBO = new DoacaoBO();
		
		Integer idMeta = Integer.parseInt(request.getParameter("idMeta"));
						
		String resultado = "";
		
		if (request.getParameter("action").compareTo("form") == 0) {
			request.setAttribute("idMeta", idMeta);
			resultado = "NovaDoacao.jsp";
						
		}else {
//			Integer idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));
			//Date data =  Date.parse(request.getParameter("txtData"));
			Date data = (Date) new java.util.Date();
			Double valor = Double.parseDouble(request.getParameter("txtValor"));
			String mensagem = request.getParameter("txtMensagem") ;
			Boolean ehAnonimo = Boolean.parseBoolean(request.getParameter("txtEhAnonimo"));
			Boolean ehNotificado = Boolean.parseBoolean(request.getParameter("txtEhNotificado"));
			resultado = doacaoBO.cadastrarDoacao(idMeta, 0, data, valor, mensagem, ehAnonimo, ehNotificado);
		}
				
		if (resultado != "NovaDoacao.jsp") {
			request.setAttribute("lista", new DoacaoBO().listarTodasDoacoes());
		}else {
			request.setAttribute("erro", "Erro ao cadastrar doacao.");
		}
		
		return resultado;
	}

}
