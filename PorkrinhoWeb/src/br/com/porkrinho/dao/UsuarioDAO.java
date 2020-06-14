package br.com.porkrinho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.porkrinho.bean.UsuarioBean;


public class UsuarioDAO{
	private Connection conn;
	private PreparedStatement ps;//representa execucao sql
	private Statement st;
	private ResultSet rs;
	
	public UsuarioDAO() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public boolean login(String email, String senha){
		String sql = "SELECT email,senha FROM usuario";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);//retorna uma lista de valores, varre a lista e bota na this.lista
			while(rs.next()) {
				String email1 = rs.getString("email");
				String senha1 = rs.getString("senha");
				if(email1.compareTo(email) == 0 && 
						senha1.compareTo(senha) == 0){
					//retorn o usuario pro singleton
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
