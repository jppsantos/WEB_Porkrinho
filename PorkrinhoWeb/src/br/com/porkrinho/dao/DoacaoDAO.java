package br.com.porkrinho.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.porkrinho.bean.DoacaoBean;

public class DoacaoDAO {
	private Connection conn;
	private PreparedStatement ps;//representa execucao sql
	private Statement st;
	private ResultSet rs;
	private ArrayList<DoacaoBean> lista;
	
	
	public DoacaoDAO() {
		conn = new ConnectionFactory().getConnection();
		lista = new ArrayList<DoacaoBean>();
	}
	
	public Boolean cadastraDoacao(DoacaoBean doacaoBean) {
		String sql  = "INSERT INTO Doacao (data, valor, mensagem, Meta_idMeta, Usuario_idUsuario, ehAnonimo, ehNotificado) values(?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setDate(0, new java.sql.Date(doacaoBean.getData().getTime()));
			ps.setDouble(1, doacaoBean.getValor());
			ps.setString(2, doacaoBean.getMensagem());
			ps.setInt(3, doacaoBean.getIdMeta());
			ps.setInt(4, doacaoBean.getIdUsuario());
			ps.setBoolean(5, doacaoBean.getEhAnonimo());
			ps.setBoolean(6, doacaoBean.getEhNotificado());
			
			ps.execute();
			ps.close();
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<DoacaoBean> listarTodasDoacoes() {
		String sql = "SELECT * FROM Doacao";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Integer idDoacao = rs.getInt(0);
				Integer idMeta = rs.getInt(4);
				Integer idUsuario = rs.getInt(5);
				Date data = rs.getDate(1);
				Double valor = rs.getDouble(2);
				String mensagem = rs.getString(3);
				Boolean ehAnonimo = rs.getBoolean(6);
				Boolean ehNotificado = rs.getBoolean(7);
				
				DoacaoBean doacaoBean = new DoacaoBean(idMeta, idUsuario, data, valor, mensagem, ehAnonimo, ehNotificado);
				doacaoBean.setIdDoacao(idDoacao);
				lista.add(doacaoBean);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}
	
	public ArrayList<DoacaoBean> listarTodasDoacoes(int idMetaProcurada) {
		String sql = "SELECT * FROM Doacao WHERE Meta_idMeta = '" + idMetaProcurada +  "'";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Integer idDoacao = rs.getInt(0);
				Integer idMeta = rs.getInt(4);
				Integer idUsuario = rs.getInt(5);
				Date data = rs.getDate(1);
				Double valor = rs.getDouble(2);
				String mensagem = rs.getString(3);
				Boolean ehAnonimo = rs.getBoolean(6);
				Boolean ehNotificado = rs.getBoolean(7);
				
				DoacaoBean doacaoBean = new DoacaoBean(idMeta, idUsuario, data, valor, mensagem, ehAnonimo, ehNotificado);
				doacaoBean.setIdDoacao(idDoacao);
				lista.add(doacaoBean);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}
	
	public ArrayList<DoacaoBean> listarMinhasDoacoes(int idUsuarioProcurado) {
		String sql = "SELECT * FROM Doacao WHERE Usuario_idUsuario = '" + idUsuarioProcurado + "'";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Integer idDoacao = rs.getInt(0);
				Integer idMeta = rs.getInt(4);
				Integer idUsuario = rs.getInt(5);
				Date data = rs.getDate(1);
				Double valor = rs.getDouble(2);
				String mensagem = rs.getString(3);
				Boolean ehAnonimo = rs.getBoolean(6);
				Boolean ehNotificado = rs.getBoolean(7);
				
				DoacaoBean doacaoBean = new DoacaoBean(idMeta, idUsuario, data, valor, mensagem, ehAnonimo, ehNotificado);
				doacaoBean.setIdDoacao(idDoacao);
				lista.add(doacaoBean);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}
	
	public DoacaoBean buscarPorId(int idDoacaoProcurada) {
		String sql = "SELECT * FROM Doacao WHERE idTransacao = '" + idDoacaoProcurada + "'";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			rs.next();
			
			Integer idDoacao = rs.getInt(0);
			Integer idMeta = rs.getInt(4);
			Integer idUsuario = rs.getInt(5);
			Date data = rs.getDate(1);
			Double valor = rs.getDouble(2);
			String mensagem = rs.getString(3);
			Boolean ehAnonimo = rs.getBoolean(6);
			Boolean ehNotificado = rs.getBoolean(7);
			
			DoacaoBean doacaoBean = new DoacaoBean(idMeta, idUsuario, data, valor, mensagem, ehAnonimo, ehNotificado);
			doacaoBean.setIdDoacao(idDoacao);
			
			rs.close();
			st.close();
			
			return doacaoBean;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	

	public boolean atualizarDoacao(DoacaoBean doacaoBean) {
		String sql = "UPDATE Doacao SET mensagem = '?',ehAnonimo = '?', ehNotificado = '?' WHERE idTransacao = '" + doacaoBean.getIdDoacao() + "'";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(0, doacaoBean.getMensagem());
			ps.setBoolean(1, doacaoBean.getEhAnonimo());
			ps.setBoolean(2, doacaoBean.getEhNotificado());
			
			ps.execute();
			ps.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean excluirDoacao(int idDoacao) {
		
		String sql = "DELETE FROM Doacao WHERE idTransacao = '" + idDoacao + "'";
		
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	

}
