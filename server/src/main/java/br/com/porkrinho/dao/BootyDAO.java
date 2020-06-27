package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.porkrinho.bean.BootyBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class BootyDAO {
  private Connection conn;
  private PreparedStatement ps;
	private Statement st;
  private ResultSet rs;

  public BootyDAO() {
    conn = new ConnectionFactory().getConnection();
  }

  public boolean add(BootyBean booty) {
    String sql = "INSERT INTO booty (date, value, status, user_idUser, goal_idGoal) "
      +"VALUES (?, ?, ?, ?, ?)";

      try {
        ps = conn.prepareStatement(sql);

        ps.setDate(1, booty.getDate());
        ps.setDouble(2, booty.getValue());
        ps.setString(3, booty.getStatus());
        ps.setInt(4, booty.getIdUser());
        ps.setInt(5, booty.getIdGoal());

        ps.execute();
        ps.close();
        return true;
      } catch (Exception e) {
        throw new RuntimeException("Erro ao cadastrar meta\n"+e);
      }
  }

  public List<BootyBean> getByInt(String column, int value) {
    List<BootyBean> bootys = new ArrayList<BootyBean>();

    String sql = "SELECT * FROM booty WHERE "+column+" = "+value;

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        BootyBean booty = new BootyBean(
          rs.getDate("date"), 
          rs.getDouble("value"), 
          rs.getString("status"), 
          rs.getInt("idUser"), 
          rs.getInt("idGoal")
        );
        booty.setIdBooty(rs.getInt("idBooty"));
        bootys.add(booty);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar saques "+e);
    }
    return bootys;
  }

  public List<BootyBean> getByString(String column, String value) {
    List<BootyBean> bootys = new ArrayList<BootyBean>();

    String sql = "SELECT * FROM booty WHERE "+column+" LIKE '%"+value+"%'";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        BootyBean booty = new BootyBean(
          rs.getDate("date"), 
          rs.getDouble("value"), 
          rs.getString("status"), 
          rs.getInt("idUser"), 
          rs.getInt("idGoal")
        );
        booty.setIdBooty(rs.getInt("idBooty"));
        bootys.add(booty);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar saques "+e);
    }
    return bootys;
  }

  public List<BootyBean> getAll() {
    List<BootyBean> bootys = new ArrayList<BootyBean>();

    String sql = "SELECT * FROM booty";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        BootyBean booty = new BootyBean(
          rs.getDate("date"), 
          rs.getDouble("value"), 
          rs.getString("status"), 
          rs.getInt("idUser"), 
          rs.getInt("idGoal")
        );
        booty.setIdBooty(rs.getInt("idBooty"));
        bootys.add(booty);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar saques "+e);
    }
    return bootys;
  }
}