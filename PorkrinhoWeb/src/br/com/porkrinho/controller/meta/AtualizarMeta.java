package br.com.porkrinho.controller.meta;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bean.MetaBean;
import br.com.porkrinho.bo.MetaBO;
import br.com.porkrinho.controller.Logica;
import br.com.porkrinho.dao.MetaDAO;

public class AtualizarMeta implements Logica{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MetaBO metaBo = new MetaBO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		String resultado = "";
		
		if (request.getParameter("action").compareTo("form") == 0) {
			
			MetaBean meta = metaBo.buscarPorId(id);
			if (meta != null) {
				request.setAttribute("titulo", meta.getTitulo());

				resultado = "formatualizar.jsp";
			}
		}else {
			//variaveis pra ser atualizadas
			resultado = metaBo.atualizarMeta(id);
		}
		request.setAttribute("lista", new MetaDAO().listarTodasMetas());
		return resultado;	
	}
}
