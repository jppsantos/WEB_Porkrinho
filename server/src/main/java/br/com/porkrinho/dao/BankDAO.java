package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.porkrinho.bean.BankBean;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class BankDAO {
  private Connection conn;
	private Statement st;
  private ResultSet rs;

  public BankDAO() {
    conn = new ConnectionFactory().getConnection();
  }

  public List<BankBean> getByInt(String column, int value) {
    List<BankBean> banks = new ArrayList<BankBean>();

    String sql = "SELECT * FROM bank WHERE "+column+" = "+value;

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        BankBean bank = new BankBean(
          rs.getString("name"), 
          rs.getInt("code")
        );
        bank.setIdBank(rs.getInt("idBank"));
        banks.add(bank);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar bancos "+e);
    }
    return banks;
  }

  public List<BankBean> getByString(String column, String value) {
    List<BankBean> banks = new ArrayList<BankBean>();

    String sql = "SELECT * FROM bank WHERE "+column+" LIKE '%"+value+"%'";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        BankBean bank = new BankBean(
          rs.getString("name"), 
          rs.getInt("code")
        );
        bank.setIdBank(rs.getInt("idBank"));
        banks.add(bank);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar bancos "+e);
    }
    return banks;
  }

  public List<BankBean> getAll() {
    List<BankBean> banks = new ArrayList<BankBean>();

    String sql = "SELECT * FROM bank";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        BankBean bank = new BankBean(
          rs.getString("name"), 
          rs.getInt("code")
        );
        bank.setIdBank(rs.getInt("idBank"));
        banks.add(bank);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar bancos "+e);
    }
    return banks;
  }
}