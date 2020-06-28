package br.com.porkrinho.bean;

public class BankBean {
  private int idBank;
  private String name;
  private int code;

  public BankBean(String name, int code) {
    this.name = name;
    this.code = code;
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

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}