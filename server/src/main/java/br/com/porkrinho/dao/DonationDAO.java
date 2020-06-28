package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.porkrinho.bean.DonationBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DonationDAO {
  private Connection conn;
	private PreparedStatement ps;
	private Statement st;
  private ResultSet rs;
  
  public DonationDAO() {
    conn = new ConnectionFactory().getConnection();
  }

  public boolean add(DonationBean donation) {
    String sql = "INSERT INTO donation (date, value, message, isAnonymous, isPublic, user_idUser, goal_idGoal) "
      +"VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {
      ps = conn.prepareStatement(sql);

      ps.setDate(1, donation.getDate());
      ps.setDouble(2, donation.getValue());
      ps.setString(3, donation.getMessage());
      ps.setBoolean(4, donation.getIsAnonymous());
      ps.setBoolean(5, donation.getIsPublic());
      ps.setInt(6, donation.getIdUser());
      ps.setInt(7, donation.getIdGoal());

      ps.execute();
      ps.close();
      return true;
    } catch (Exception e) {
      throw new RuntimeException("Erro ao cadastrar doacao\n"+e);
    }
  }

  public boolean update(DonationBean donation) {
    String sql = "UPDATE donation SET date = ? , value = ?, message = ?, isAnonymous = ?, isPublic = ?, user_idUser = ?, goal_idGoal = ? "
    +"WHERE idDonation = ?";

		try {
			ps = conn.prepareStatement(sql);
				
      ps.setDate(1, donation.getDate());
      ps.setDouble(2, donation.getValue());
      ps.setString(3, donation.getMessage());
      ps.setBoolean(4, donation.getIsAnonymous());
      ps.setBoolean(5, donation.getIsPublic());
      ps.setInt(6, donation.getIdUser());
      ps.setInt(7, donation.getIdGoal());
      ps.setInt(8, donation.getIdDonation());

      if(ps.executeUpdate() == 1) {
        ps.close();
        return true;
      } else {
        ps.close();
        return false;
      }
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar doacao\n"+e);
		}
	}

  public boolean delete(DonationBean donation) {
    String sql = "DELETE FROM donation WHERE idDonation = "+donation.getIdDonation();

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
      throw new RuntimeException("Erro ao remover doacao\n"+e);
    }
  }

  public List<DonationBean> getByInt(String column, int value) {
    List<DonationBean> donations = new ArrayList<DonationBean>();

    String sql = "SELECT * FROM donation WHERE "+column+" = "+value;

    try {
      st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
        DonationBean donation = new DonationBean(
          rs.getDate("date"), 
          rs.getDouble("value"), 
          rs.getString("message"), 
          rs.getBoolean("isAnonymous"), 
          rs.getBoolean("isPublic"), 
          rs.getInt("user_idUser"), 
          rs.getInt("goal_idGoal")
        );
        donation.setIdDonation(rs.getInt("idDonation"));
        donations.add(donation);
      }
      if(donations.isEmpty()) {
				return null;
			} else {
				return donations;
			}
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar doacoes\n"+e);
    }
  }

  public List<DonationBean> getByString(String column, String value) {
    List<DonationBean> donations = new ArrayList<DonationBean>();

    String sql = "SELECT * FROM donation WHERE "+column+" LIKE '%"+value+"%'";

    try {
      st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
        DonationBean donation = new DonationBean(
          rs.getDate("date"), 
          rs.getDouble("value"), 
          rs.getString("message"), 
          rs.getBoolean("isAnonymous"), 
          rs.getBoolean("isPublic"), 
          rs.getInt("user_idUser"), 
          rs.getInt("goal_idGoal")
        );
        donation.setIdDonation(rs.getInt("idDonation"));
        donations.add(donation);
      }
      if(donations.isEmpty()) {
				return null;
			} else {
				return donations;
			}
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar doacoes\n"+e);
    }
  }

  public List<DonationBean> getAll() {
    List<DonationBean> donations = new ArrayList<DonationBean>();

    String sql = "SELECT * FROM donation";

    try {
      st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
        DonationBean donation = new DonationBean(
          rs.getDate("date"), 
          rs.getDouble("value"), 
          rs.getString("message"), 
          rs.getBoolean("isAnonymous"), 
          rs.getBoolean("isPublic"), 
          rs.getInt("user_idUser"), 
          rs.getInt("goal_idGoal")
        );
        donation.setIdDonation(rs.getInt("idDonation"));
        donations.add(donation);
      }
      if(donations.isEmpty()) {
				return null;
			} else {
				return donations;
			}
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar doacoes\n"+e);
    }
  }
}