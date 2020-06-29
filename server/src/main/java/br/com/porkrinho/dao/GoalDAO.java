package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.porkrinho.bean.GoalBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class GoalDAO {
  private Connection conn;
	private PreparedStatement ps;
	private Statement st;
  private ResultSet rs;
  
  public GoalDAO() {
    conn = new ConnectionFactory().getConnection();
  }

  public boolean add(GoalBean goal) {
    String sql = "INSERT INTO goal (title, description, value, goalValue, createDate, idUser, isPublic, imgPath)"
      +"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

      try {
        ps = conn.prepareStatement(sql);
        
        ps.setString(1, goal.getTitle());
        ps.setString(2, goal.getDescription());
        ps.setDouble(3, goal.getValue());
        ps.setDouble(4, goal.getGoalValue());
        ps.setDate(5, goal.getCreateDate());
        ps.setInt(6, goal.getIdUser());
        ps.setBoolean(7, goal.isPublic());
        ps.setString(8, goal.getImgPath());

        ps.execute();
        ps.close();
        return true;
      } catch (Exception e) {
        throw new RuntimeException("Erro ao cadastrar meta\n"+e);
      }
  }

  public boolean update(GoalBean goal) {
    String sql = "UPDATE goal SET title = ?, description = ?, value = ?, goalValue = ?, createDate = ?, goalDate = ?, idUser = ?, isPublic = ?, imgPath = ? WHERE idGoal = ?";

      try {
        ps = conn.prepareStatement(sql);

        ps.setString(1, goal.getTitle());
        ps.setString(2, goal.getDescription());
        ps.setDouble(3, goal.getValue());
        ps.setDouble(4, goal.getGoalValue());
        ps.setDate(5, goal.getCreateDate());
        ps.setDate(6, goal.getGoalDate());
        ps.setInt(7, goal.getIdUser());
        ps.setBoolean(8, goal.isPublic());
        ps.setString(9, goal.getImgPath());
        ps.setInt(10, goal.getIdGoal());

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

  public boolean delete(GoalBean goal) {
    String sql = "DELETE FROM goal WHERE idGoal = "+goal.getIdGoal();

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

  public List<GoalBean> getByInt(String column, int value) {
    List<GoalBean> goals = new ArrayList<GoalBean>();

    String sql = "SELECT * FROM goal WHERE "+column+" = "+value;

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        GoalBean goal = new GoalBean(
          rs.getString("title"), 
          rs.getString("description"), 
          rs.getDouble("value"),
          rs.getDate("createDate"), 
          rs.getInt("idUser"), 
          rs.getBoolean("isPublic"),
          rs.getString("imgPath")
        );
        goal.setIdGoal(rs.getInt("idGoal"));
        goal.setGoalValue(rs.getDouble("goalValue"));
        goal.setGoalDate(rs.getDate("goalDate"));
        goals.add(goal);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar metas "+e);
    }

    return goals;
  }

  public List<GoalBean> getByString(String column, String value) {
    List<GoalBean> goals = new ArrayList<GoalBean>();

    String sql = "SELECT * FROM goal WHERE "+column+" LIKE '%"+value+"%'";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        GoalBean goal = new GoalBean(
          rs.getString("title"), 
          rs.getString("description"), 
          rs.getDouble("value"),
          rs.getDate("createDate"), 
          rs.getInt("idUser"), 
          rs.getBoolean("isPublic"),
          rs.getString("imgPath")
        );
        goal.setIdGoal(rs.getInt("idGoal"));
        goal.setGoalValue(rs.getDouble("goalValue"));
        goal.setGoalDate(rs.getDate("goalDate"));
        goals.add(goal);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar metas "+e);
    }

    return goals;
  }
  
  public List<GoalBean> getAll() {
    List<GoalBean> goals = new ArrayList<GoalBean>();

    String sql = "SELECT * FROM goal";

    try {
      st = conn.createStatement();
      rs = st.executeQuery(sql);
      
      while(rs.next()) {
        GoalBean goal = new GoalBean(
          rs.getString("title"), 
          rs.getString("description"), 
          rs.getDouble("value"),
          rs.getDate("createDate"), 
          rs.getInt("idUser"), 
          rs.getBoolean("isPublic"),
          rs.getString("imgPath")
        );
        goal.setIdGoal(rs.getInt("idGoal"));
        goal.setGoalValue(rs.getDouble("goalValue"));
        goal.setGoalDate(rs.getDate("goalDate"));
        goals.add(goal);
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar metas "+e);
    }

    return goals;
  }
}