package br.com.porkrinho.bean;

import java.sql.Date;

public class DonationBean {
  private int idDonation;
  private Date date;
  private double value;
  private String message;
  private boolean isAnonymous;
  private boolean isPublic;
  private int idUser;
  private int idGoal;

  public DonationBean(Date date, double value, String message, boolean isAnonymous, boolean isPublic, int idUser, int idGoal) {
    this.date = date;
    this.value = value;
    this.message = message;
    this.isAnonymous = isAnonymous;
    this.isPublic = isPublic;
    this.idUser = idUser;
    this.idGoal = idGoal;
  }

  public int getIdDonation() {
    return idDonation;
  }

  public void setIdDonation(int idDonation) {
    this.idDonation = idDonation;
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

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean getIsAnonymous() {
    return isAnonymous;
  }

  public void setIsAnonymous(boolean isAnonymous) {
    this.isAnonymous = isAnonymous;
  }

  public boolean getIsPublic() {
    return isPublic;
  }

  public void setIsPublic(boolean isPublic) {
    this.isPublic = isPublic;
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