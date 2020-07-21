package br.com.porkrinho.bo;

import java.util.List;

import com.google.gson.Gson;

import br.com.porkrinho.bean.BootyBean;
import br.com.porkrinho.dao.BootyDAO;

public class BootyBO {
  private static BootyDAO bootyDAO = new BootyDAO();
  private static Gson gson = new Gson();

  public String addBooty(BootyBean booty) {
    if(bootyDAO.add(booty)) {
      return gson.toJson("ok");
		} else {
			return gson.toJson("Erro ao cadastrar saque!");
		}
  }

  public List<BootyBean> listAllBootys() {
    return bootyDAO.getAll();
  }
}