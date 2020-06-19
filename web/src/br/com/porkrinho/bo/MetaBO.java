package br.com.porkrinho.bo;

import java.util.Date;
import java.util.List;

import br.com.porkrinho.bean.MetaBean;
import br.com.porkrinho.dao.MetaDAO;

public class MetaBO {
	
	public String cadastrarMeta(int usuarioId, String titulo, String descricao, Double valorMeta, String pathImg,
			Date dataLimite, boolean ehPublico) {

		MetaBean metaBean = new MetaBean( usuarioId, titulo, descricao, valorMeta, 0.0, pathImg, dataLimite, ehPublico);

		if(new MetaDAO().cadastrarMeta(metaBean)) {
			return "TratarMeta/ListarMinhasMetas.jsp";
		}
		return "NovaMeta.jsp";
	}

	public List<MetaBean> listarMinhasMetas(int idUsuario){ 
		return new MetaDAO().listarMinhasMetas(idUsuario);
	}

	public List<MetaBean> listarTodasMetas(){ 
		return new MetaDAO().listarTodasMetas();
	}

	public String atualizarMeta(int id) {

		if(new MetaDAO().atualizarMeta(id)) {
			return "";
		}
		return "";
	}

	public String excluirMeta(int id) {
		MetaDAO metaDao = new MetaDAO();
//		MetaBean meta = metaDao.buscarPorId(id);
		if(metaDao.excluirMeta(id)) {
			return "";
		}
		return "";
	}

	public MetaBean buscarPorId(int id) {
		return new MetaDAO().buscarPorId(id);
	}
}
