package br.com.porkrinho.bean;

public class UserBean {
  private int idUser;
	private String name;
	private String lastName;
  private String cpf;
  private int age;
	private String email;
  private String phone;
  private String password;
  private int bankAgency;
  private int bankAccount;
  private String imgPath;
  private int idBank;

  public UserBean(String name, String lastName, String cpf, int age, String email, String phone, String password, int bankAgency, int bankAccount, String imgPath, int idBank) {
    this.name = name;
    this.lastName = lastName;
    this.cpf = cpf;
    this.age = age;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.bankAgency = bankAgency;
    this.bankAccount = bankAccount;
    this.imgPath = imgPath;
    this.idBank = idBank;
  }

  public UserBean(String cpf, String password) {
    this.cpf = cpf;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getBankAgency() {
    return bankAgency;
  }

  public void setBankAgency(int bankAgency) {
    this.bankAgency = bankAgency;
  }

  public int getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(int bankAccount) {
    this.bankAccount = bankAccount;
  }

  public String getImgPath() {
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }

  public int getIdBank() {
    return idBank;
  }

  public void setIdBank(int idBank) {
    this.idBank = idBank;
  }
}