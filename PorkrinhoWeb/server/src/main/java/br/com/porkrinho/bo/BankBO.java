package br.com.porkrinho.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.porkrinho.bean.BankBean;
import br.com.porkrinho.dao.BankDAO;

public class BankBO {
  private static BankDAO bankDAO = new BankDAO();

  public List<BankBean> listAllBanks() {
    return bankDAO.getAll();
  }

  public BankBean getBankById(int id) {
    for(BankBean bank : bankDAO.getByInt("idBank", id)) {
      if(bank.getIdBank() == id) {
        return bank;
      }
    }

    return null;
  }

  public List<BankBean> getBankByName(String name) {
    List<BankBean> banks = new ArrayList<BankBean>();

    for(BankBean bank : bankDAO.getByString("name", name)) {
      if(bank.getName().toLowerCase().contains(name)) {
        banks.add(bank);
      }
    }

    return banks;
  }

  public BankBean getBankByCode(int code) {
    for(BankBean bank : bankDAO.getByInt("code", code)) {
      if(bank.getCode() == code) {
        return bank;
      }
    }

    return null;
  }
}