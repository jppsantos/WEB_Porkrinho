package br.com.porkrinho.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MarkBean {
  private int idMark;
  private int idUser;
  private String title;
  private String description;
  private double currentValue;
  private double markValue;
  private String pathImg;
  private Date finalDate;
  private boolean isPublic;

  public MarkBean(int idUser, String title, String description, double currentValue, double markValue, String pathImg, Date finalDate, boolean isPublic) {
    this.idUser = idUser;
    this.title = title;
    this.description = description;
    this.currentValue = currentValue;
    this.markValue = markValue;
    this.pathImg = pathImg;
    this.finalDate = finalDate;
    //this.finalDate = LocalDate.parse(finalDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    this.isPublic = isPublic;
  }

  public int getIdMark() {
    return idMark;
  }

  public void setIdMark(int idMark) {
    this.idMark = idMark;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(double currentValue) {
    this.currentValue = currentValue;
  }

  public double getMarkValue() {
    return markValue;
  }

  public void setMarkValue(double markValue) {
    this.markValue = markValue;
  }

  public String getPathImg() {
    return pathImg;
  }

  public void setPathImg(String pathImg) {
    this.pathImg = pathImg;
  }

  public Date getFinalDate() {
    return finalDate;
    //return finalDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public void setFinalDate(Date finalDate) {
    this.finalDate = finalDate;
    //this.finalDate = LocalDate.parse(finalDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean isPublic) {
    this.isPublic = isPublic;
  }
}