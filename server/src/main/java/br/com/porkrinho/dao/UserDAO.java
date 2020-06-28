package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import br.com.porkrinho.bean.UserBean;

public class UserDAO {
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;

  public UserDAO() {
		conn = new ConnectionFactory().getConnection();
  }
	
	public boolean add(UserBean user) {
		String sql = "INSERT INTO user (name, lastname, cpf, age, email, phone, password, bankAgency, bankAccount, imgPath, bank_idBank)"
			+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getCpf());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getPassword());
			ps.setInt(8, user.getBankAgency());
			ps.setInt(9, user.getBankAccount());
			ps.setString(10, user.getImgPath());
			ps.setInt(11, user.getIdBank());
			ps.execute();
			ps.close();

			return true;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao cadastrar usuario\n"+e);
		}
	}

	public boolean update(UserBean user) {
		String sql = "UPDATE user SET name = ? , lastname = ?, cpf = ?, age = ?, email = ?, phone = ?, password = ?, bankAgency = ?, bankAccount = ?, imgPath = ?, bank_idBank = ? " 
		+"WHERE idUser = ?";

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getCpf());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getPassword());
			ps.setInt(8, user.getBankAgency());
			ps.setInt(9, user.getBankAccount());
			ps.setString(10, user.getImgPath());
			ps.setInt(11, user.getIdBank());
			ps.setInt(12, user.getIdUser());

			if(ps.executeUpdate() == 1) {
				ps.close();
				return true;
			} else {
				ps.close();
				return false;
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar usuario\n"+e);
		}
	}

	public boolean delete(UserBean user) {
    String sql = "DELETE FROM user WHERE idUser = "+user.getIdUser();

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
      throw new RuntimeException("Erro ao remover usuario\n"+e);
    }
  }

	public List<UserBean> getByInt(String column, int value) {
		List<UserBean> users = new ArrayList<UserBean>();

		String sql = "SELECT * FROM user WHERE "+column+" = "+value;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				UserBean user = new UserBean(
					rs.getString("name"), 
					rs.getString("lastname"), 
					rs.getString("cpf"), 
					rs.getInt("age"), 
					rs.getString("email"), 
					rs.getString("phone"), 
					rs.getString("password"),
					rs.getInt("bankAgency"),
					rs.getInt("bankAccount"),
					rs.getString("imgPath"),
					rs.getInt("bank_idBank")
				);
				user.setIdUser(rs.getInt("idUser"));
				users.add(user);
			}
			if(users.isEmpty()) {
				return null;
			} else {
				return users;
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao listar usuarios\n"+e);
		}
	}

	public List<UserBean> getByString(String column, String value) {
		List<UserBean> users = new ArrayList<UserBean>();

		String sql = "SELECT * FROM user WHERE "+column+" LIKE '%"+value+"%'";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				UserBean user = new UserBean(
					rs.getString("name"), 
					rs.getString("lastname"), 
					rs.getString("cpf"), 
					rs.getInt("age"), 
					rs.getString("email"), 
					rs.getString("phone"), 
					rs.getString("password"),
					rs.getInt("bankAgency"),
					rs.getInt("bankAccount"),
					rs.getString("imgPath"),
					rs.getInt("bank_idBank")
				);
				user.setIdUser(rs.getInt("idUser"));
				users.add(user);
			}
			if(users.isEmpty()) {
				return null;
			} else {
				return users;
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao listar usuarios\n"+e);
		}
	}

  public List<UserBean> getAll() {
		List<UserBean> users = new ArrayList<UserBean>();

		String sql = "SELECT * FROM user";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				UserBean user = new UserBean(
					rs.getString("name"), 
					rs.getString("lastname"), 
					rs.getString("cpf"), 
					rs.getInt("age"), 
					rs.getString("email"), 
					rs.getString("phone"), 
					rs.getString("password"),
					rs.getInt("bankAgency"),
					rs.getInt("bankAccount"),
					rs.getString("imgPath"),
					rs.getInt("bank_idBank")
				);
				user.setIdUser(rs.getInt("idUser"));
				users.add(user);
			}
			if(users.isEmpty()) {
				return null;
			} else {
				return users;
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao listar usuarios\n"+e);
		}
	}
}