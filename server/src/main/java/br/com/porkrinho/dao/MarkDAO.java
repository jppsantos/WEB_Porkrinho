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
    String sql = "INSERT INTO meta (idDono, titulo, descricao, valoratual, valormeta, imagem, datalimite, publica)"
      +"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

      try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, mark.getIdUser());
        ps.setString(2, mark.getTitle());
        ps.setString(3, mark.getDescription());
        ps.setDouble(4, mark.getCurrentValue());
        ps.setDouble(5, mark.getMarkValue());
        ps.setString(6, mark.getPathImg());
        ps.setDate(7, mark.getFinalDate());
        ps.setBoolean(8, mark.isPublic());
        ps.execute();
        ps.close();
        
        return true;
      } catch (Exception e) {
        throw new RuntimeException("Erro ao cadastrar meta\n"+e);
      }
  }

  public boolean updateMark(MarkBean mark) {
    String sql = "UPDATE meta SET iddono = ?, titulo = ?, descricao = ?, valoratual = ?, valormeta = ?, imagem = ?, datalimite = ?, publica = ? WHERE idmeta = ?";

      try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, mark.getIdUser());
        ps.setString(2, mark.getTitle());
        ps.setString(3, mark.getDescription());
        ps.setDouble(4, mark.getCurrentValue());
        ps.setDouble(5, mark.getMarkValue());
        ps.setString(6, mark.getPathImg());
        ps.setDate(7, mark.getFinalDate());
        ps.setBoolean(8, mark.isPublic());
        ps.setInt(9, mark.getIdMark());
        if(ps.executeUpdate() == 1) {
          ps.close();
          return true;
        } else {
          ps.close();
          return false;
        }
      } catch (Exception e) {
        throw new RuntimeException("Erro ao atualizar a meta\n"+e);
      }
  }

  public boolean deleteMark(MarkBean mark) {
    String sql = "DELETE FROM meta WHERE idmeta = "+mark.getIdMark();

    try {
      st = conn.createStatement();
      if(st.executeUpdate(sql) == 1) {
				st.close();
				return true;
			} else {
        st.close();
        return false;
			}
    } catch (Exception e) {
      throw new RuntimeException("Erro ao remover a meta\n"+e);
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
          rs.getDate("datalimite"),
          rs.getBoolean("publica")
        );
        mark.setIdMark(rs.getInt("idmeta"));
        marks.add(mark);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar metas "+e);
    }

    return marks;
  }
}