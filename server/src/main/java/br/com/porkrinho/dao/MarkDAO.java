package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.porkrinho.bean.MarkBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class MarkDAO {
  private Connection conn;
	private PreparedStatement ps;
	private Statement st;
  private ResultSet rs;
  
  public MarkDAO() {
    conn = new ConnectionFactory().getConnection();
  }

  public boolean addMark(MarkBean mark) {
    String sql = "INSERT INTO meta (iddono, titulo, descricao, valoratual, valormeta, imagem, publica)"
      +"VALUES (?, ?, ?, ?, ?, ?, ?)";

      try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, mark.getIdUser());
        ps.setString(2, mark.getTitle());
        ps.setString(3, mark.getDescription());
        ps.setDouble(4, mark.getCurrentValue());
        ps.setDouble(5, mark.getMarkValue());
        ps.setString(6, mark.getPathImg());
        ps.setBoolean(7, mark.isPublic());
        ps.execute();
        ps.close();
        
        return true;
      } catch (Exception e) {
        throw new RuntimeException("Erro ao cadastrar meta\n"+e);
      }
  }

  public List<MarkBean> getAllMarks() {
    List<MarkBean> marks = new ArrayList<MarkBean>();

    String sql = "SELECT * FROM meta";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        MarkBean mark = new MarkBean(
          rs.getInt("iddono"), 
          rs.getString("titulo"), 
          rs.getString("descricao"), 
          rs.getDouble("valoratual"), 
          rs.getDouble("valormeta"), 
          rs.getString("imagem"), 
          rs.getBoolean("publica")
        );
        mark.setFinalDate(rs.getDate("datalimite"));
        mark.setIdMark(rs.getInt("idmeta"));
        marks.add(mark);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar metas "+e);
    }

    return marks;
  }
}