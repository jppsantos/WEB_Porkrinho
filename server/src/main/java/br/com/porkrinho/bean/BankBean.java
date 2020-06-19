package br.com.porkrinho.bean;

public class BankBean {
  private int idBank;
  private String name;
  private int codBank;

  public BankBean(String name, int codBank) {
    this.name = name;
    this.codBank = codBank;
  }

  public int getIdBank() {
    return idBank;
  }

  public void setIdBank(int idBank) {
    this.idBank = idBank;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCodBank() {
    return codBank;
  }

  public void setCodBank(int codBank) {
    this.codBank = codBank;
  }
}