package br.com.porkrinho.controller.doacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.porkrinho.bo.DoacaoBO;
import br.com.porkrinho.bo.MetaBO;
import br.com.porkrinho.controller.Logica;

public class ExcluirDoacao implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DoacaoBO doacaoBO = new DoacaoBO();
		
		int id = Integer.parseInt(request.getParameter("txtIdDoacao"));
		Integer idUsuario = doacaoBO.buscarPorId(id).getIdUsuario();
		String resultado = doacaoBO.excluirDoacao(id);
		
		if (resultado == "") {
			request.setAttribute("lista", new DoacaoBO().listarMinhasDoacoes(idUsuario));
		}else {
			request.setAttribute("erro", "Erro ao excluir doacao.");
		}		
		return resultado;
		
	}

}
