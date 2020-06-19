package br.com.porkrinho.bean;

public class UserBean {
  private int idUser;
	private String name;
	private String lastName;
	private String cpf;
	private String email;
	private String password;
	private String phone;
	private int idBank;
  private int agency;
  private int account;
  private String pathImg;

  public UserBean(String name, String lastName, String cpf, String email, String password, String phone, int idBank, int agency, int account, String pathImg) {
    this.name = name;
    this.lastName = lastName;
    this.cpf = cpf;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.idBank = idBank;
    this.agency = agency;
    this.account = account;
    this.pathImg = pathImg;
  }
  
  public UserBean(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getIdBank() {
    return idBank;
  }

  public void setIdBank(int idBank) {
    this.idBank = idBank;
  }

  public int getAgency() {
    return agency;
  }

  public void setAgency(int agency) {
    this.agency = agency;
  }

  public int getAccount() {
    return account;
  }

  public void setAccount(int account) {
    this.account = account;
  } 
  public String getPathImg() {
    return pathImg;
  }

  public void setPathImg(String pathImg) {
    this.pathImg = pathImg;
  }
}