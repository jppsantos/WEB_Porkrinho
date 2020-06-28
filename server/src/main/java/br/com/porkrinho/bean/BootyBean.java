package br.com.porkrinho.bean;

import java.sql.Date;

public class BootyBean {
  private int idBooty;
  private Date date;
  private double value;
  private String status;
  private int idUser;
  private int idGoal;

  public BootyBean(Date date, double value, String status, int idUser, int idGoal) {
    this.date = date;
    this.value = value;
    this.status = status;
    this.idUser = idUser;
    this.idGoal = idGoal;
  }

  public int getIdBooty() {
    return idBooty;
  }

  public void setIdBooty(int idBooty) {
    this.idBooty = idBooty;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public int getIdGoal() {
    return idGoal;
  }

  public void setIdGoal(int idGoal) {
    this.idGoal = idGoal;
  }
}