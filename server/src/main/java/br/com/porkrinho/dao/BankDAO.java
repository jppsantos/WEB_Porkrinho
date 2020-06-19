package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.porkrinho.bean.BankBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class BankDAO {
  private Connection conn;
	private PreparedStatement ps;
	private Statement st;
  private ResultSet rs;
  private static List<BankBean> banks = null;

  public BankDAO() {
    if(banks == null) {
      banks = new ArrayList<BankBean>();
      conn = new ConnectionFactory().getConnection();
    }
  }

  public List<BankBean> getAllBanks() {
    List<BankBean> banks = new ArrayList<BankBean>();

    String sql = "SELECT * FROM banco";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        BankBean bank = new BankBean(
          rs.getString("nome"), 
          rs.getInt("codigo")
        );
        bank.setIdBank(rs.getInt("idbanco"));
        banks.add(bank);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar bancos "+e);
    }
    return banks;
  }
}