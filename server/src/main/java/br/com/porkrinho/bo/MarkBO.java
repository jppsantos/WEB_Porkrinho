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

  public String updateMark(MarkBean mark) {
    if(markDAO.updateMark(mark)) {
      return gson.toJson("ok");
    } else {
      return gson.toJson("Erro ao atualizar meta!");
    }
  }

  public String deleteMark(int id) {
    for(MarkBean mark : markDAO.getAllMarks()) {
      if(mark.getIdMark() == id) {
        if(markDAO.deleteMark(mark)) {
          return gson.toJson("ok");
        } else {
          return gson.toJson("Erro ao deletar meta!");
        }
      }
    }
    return gson.toJson("Meta não encontrada!");
  }

  public MarkBean getMarkById(int id) {
    for(MarkBean mark : markDAO.getAllMarks()) {
      if(mark.getIdMark() == id) {
        return mark;
      }
    }
    return null;
  }

  public List<MarkBean> listAllMarks() {
    return markDAO.getAllMarks();
  }
}