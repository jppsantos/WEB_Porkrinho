package br.com.porkrinho.bo;

import java.util.List;

import com.google.gson.Gson;

import br.com.porkrinho.bean.MarkBean;
import br.com.porkrinho.dao.MarkDAO;

public class MarkBO {
  private static MarkDAO markDAO = new MarkDAO();
  private static Gson gson = new Gson();

  public String addMark(MarkBean mark) {
    if(markDAO.addMark(mark)) {
      return gson.toJson("ok");
		} else {
			return gson.toJson("Erro ao cadastrar meta!");
		}
  }

  public List<MarkBean> listAllMarks() {
    return markDAO.getAllMarks();
  }
}