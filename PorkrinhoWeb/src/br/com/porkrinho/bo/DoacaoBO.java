package br.com.porkrinho.bo;

import java.util.Date;
import java.util.List;

import br.com.porkrinho.bean.DoacaoBean;
import br.com.porkrinho.dao.DoacaoDAO;

public class DoacaoBO {
	
	public String cadastrarUsuario(Integer idMeta, Integer idUsuario, Date data, Double valor, String mensagem, Boolean ehAnonimo, Boolean ehNotificado) {
		DoacaoBean doacaoBean = new DoacaoBean(idMeta, idUsuario, data, valor, mensagem, ehAnonimo, ehNotificado);
		
		if (new DoacaoDAO().cadastraDoacao(doacaoBean)) {
			return "";
		}
		return "";
	}
	
	public List<DoacaoBean> listarMinhasDoacoes(int idUsuario){ 
		return new DoacaoDAO().listarMinhasDoacoes(idUsuario);
	}

	public List<DoacaoBean> listarTodasDoacoes(){ 
		return new DoacaoDAO().listarTodasDoacoes();
	}
	
	public List<DoacaoBean> listarTodasDoacoes(int idMeta){ 
		return new DoacaoDAO().listarTodasDoacoes(idMeta);
	}
	
	

	public String atualizarDoacao(Integer idDoacao, Boolean ehAnonimo, Boolean ehNotificado) {
		
		DoacaoBean doacaoBean = new DoacaoDAO().buscarPorId(idDoacao);
		doacaoBean.setEhAnonimo(ehAnonimo);
		doacaoBean.setEhNotificado(ehNotificado);
		
		if(new DoacaoDAO().atualizarDoacao(doacaoBean)) {
			return "";
		}
		return "";
	}

	public String excluirDoacao(int id) {
		DoacaoDAO doacaoDAO = new DoacaoDAO();
		
		if(doacaoDAO.excluirDoacao(id)) {
			return "";
		}
		return "";
	}

	public DoacaoBean buscarPorId(int id) {
		return new DoacaoDAO().buscarPorId(id);
	}
	
}
