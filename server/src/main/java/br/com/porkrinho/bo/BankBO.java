package br.com.porkrinho.bo;

import java.util.List;

import br.com.porkrinho.bean.BankBean;
import br.com.porkrinho.dao.BankDAO;

public class BankBO {
  private static BankDAO bankDAO = new BankDAO();

  public void addBank(String json) {

  }

  public List<BankBean> listAllBanks() {
    return bankDAO.getAllBanks();
  }
}