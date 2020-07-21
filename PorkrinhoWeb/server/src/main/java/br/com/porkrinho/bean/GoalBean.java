package br.com.porkrinho.bean;

import java.sql.Date;

public class GoalBean {
  private int idGoal;
  private String title;
  private String description;
  private double value;
  private double goalValue;
  private Date createDate;
  private Date goalDate;
  private int idUser;
  private boolean isPublic;
  private String imgPath;

  public GoalBean(String title, String description, double value, Date createDate, int idUser, boolean isPublic, String imgPath) {
    this.title = title;
    this.description = description;
    this.value = value;
    this.createDate = createDate;
    this.idUser = idUser;
    this.isPublic = isPublic;
    this.imgPath = imgPath;
  }

  public int getIdGoal() {
    return idGoal;
  }

  public void setIdGoal(int idGoal) {
    this.idGoal = idGoal;
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

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public double getGoalValue() {
    return goalValue;
  }

  public void setGoalValue(double goalValue) {
    this.goalValue = goalValue;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getGoalDate() {
    return goalDate;
  }

  public void setGoalDate(Date goalDate) {
    this.goalDate = goalDate;
  }

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean isPublic) {
    this.isPublic = isPublic;
  }

  public String getImgPath() {
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }
}