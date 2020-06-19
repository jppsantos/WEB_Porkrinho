package br.com.porkrinho.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

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
	
	public boolean addUser(UserBean user) {
		String sql = "INSERT INTO usuario (nome, sobrenome, cpf, email, senha, telefone, banco_idbanco, agencia, conta)"
			+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getCpf());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getPassword());
				ps.setString(6, user.getPhone());
				ps.setInt(7, user.getIdBank());
				ps.setInt(8, user.getAgency());
				ps.setInt(9, user.getAccount());
				ps.execute();
				ps.close();

				return true;
			} catch (Exception e) {
				throw new RuntimeException("Erro ao cadastrar usuario\n"+e);
			}
	}

	public UserBean getUserById(int id) {
		String sql = "SELECT * FROM usuario WHERE idusuario = "+id;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				UserBean user = new UserBean(
					rs.getString("nome"), 
					rs.getString("sobrenome"), 
					rs.getString("cpf"), 
					rs.getString("email"), 
					rs.getString("senha"), 
					rs.getString("telefone"), 
					rs.getInt("banco_idbanco"),
					rs.getInt("agencia"),
					rs.getInt("conta"),
					rs.getString("imagem")
				);
				user.setIdUser(rs.getInt("idusuario"));

				return user;
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar usuario de id "+id+"\n"+e);
		}
		return null;
	}

	public List<UserBean> getUserByCpf(String cpf) {
		List<UserBean> users = new ArrayList<UserBean>();

		String sql = "SELECT * FROM usuario WHERE cpf = "+cpf;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				UserBean user = new UserBean(
					rs.getString("nome"), 
					rs.getString("sobrenome"), 
					rs.getString("cpf"), 
					rs.getString("email"), 
					rs.getString("senha"), 
					rs.getString("telefone"), 
					rs.getInt("banco_idbanco"),
					rs.getInt("agencia"),
					rs.getInt("conta"),
					rs.getString("imagem")
				);
				user.setIdUser(rs.getInt("idusuario"));
				users.add(user);
			}
			if(users.isEmpty()) {
				return null;
			} else {
				return users;
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar usuario de id "+cpf+"\n"+e);
		}
	}

  public List<UserBean> getAllUsers() {
		List<UserBean> users = new ArrayList<UserBean>();

		String sql = "SELECT * FROM usuario";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				UserBean user = new UserBean(
					rs.getString("nome"), 
					rs.getString("sobrenome"), 
					rs.getString("cpf"), 
					rs.getString("email"), 
					rs.getString("senha"), 
					rs.getString("telefone"), 
					rs.getInt("banco_idbanco"),
					rs.getInt("agencia"),
					rs.getInt("conta"),
					rs.getString("imagem")
				);
				user.setIdUser(rs.getInt("idusuario"));
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