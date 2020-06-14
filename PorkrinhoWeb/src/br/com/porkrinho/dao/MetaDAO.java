package br.com.porkrinho.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import br.com.porkrinho.bean.MetaBean;

public class MetaDAO {
	private Connection conn;
	private PreparedStatement ps;//representa execucao sql
	private Statement st;
	private ResultSet rs;
	private ArrayList<MetaBean> lista;
	
	public MetaDAO() {
		conn = new ConnectionFactory().getConnection();
		lista = new ArrayList<MetaBean>();
	}
	
	public boolean cadastraMeta(MetaBean metaBean) {
		String sql = "INSERT INTO meta (id_dono,titulo, descricao, valorMeta, dataLimite, ehPublico, imagem) values(?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, metaBean.getUsuarioId());
			ps.setString(2, metaBean.getTitulo());
			ps.setString(3, metaBean.getDescricao());
			ps.setDouble(4, metaBean.getValorMeta());
			ps.setDate(5, metaBean.getDataLimite());
			ps.setBoolean(6, metaBean.getEhPublico());
			ps.setString(6, metaBean.getPathImg());
			ps.execute();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;		
		}
	}

	public ArrayList<MetaBean> listarMinhasMetas(int idUsuario){
		String sql = "SELECT * FROM meta WHERE id_dono ='"+idUsuario+"'";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);//retorna uma lista de valores, varre a lista e bota na this.lista
			while (rs.next()) {
				MetaBean metaBean = new MetaBean(rs.getInt("id_dono"), rs.getString("titulo"), rs.getString("descricao"), rs.getDouble("valor_meta"), rs.getString("img"), rs.getDate("data_limite"), rs.getBoolean("eh_publico"));
				metaBean.setId(rs.getInt("id_meta"));
				lista.add(metaBean);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}
	
	public ArrayList<MetaBean> listarTodasMetas(){
		String sql = "SELECT * FROM meta";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);//retorna uma lista de valores, varre a lista e bota na this.lista
			while (rs.next()) {
				MetaBean metaBean = new MetaBean(rs.getInt("id_dono"), rs.getString("titulo"), rs.getString("descricao"), rs.getDouble("valor_meta"), rs.getString("img"), rs.getDate("data_limite"), rs.getBoolean("eh_publico"));
				metaBean.setId(rs.getInt("id_meta"));
				lista.add(metaBean);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return lista;
	}
	
	public boolean alugarCarro(int id) {
		String sql = "UPDATE carro SET taAlugado = '"+1+"' WHERE idcarro = '"+id+"'";
		
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean excluirMeta(int id) {
		
		String sql = "DELETE FROM meta WHERE id_meta = '"+id+"'";
		
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
	
	public boolean atualizarMeta(int id) {
//		String sql = "UPDATE meta SET cor = ?,valor = ? WHERE id_meta = ?";
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, cor);
//			ps.setFloat(2, valor);
//			ps.setInt(3, id);
//			ps.execute();
//			ps.close();
//			return true;
//		} catch (Exception e) {
//			return false;		
//		}
	return false;
	}
	
	public MetaBean buscarPorId(int id) {
		String sql = "SELECT * FROM meta WHERE id_meta = '"+id+"'";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);//retorna uma lista de valores, varre a lista e bota na this.lista
			rs.next();
			MetaBean metaBean = new MetaBean(rs.getInt("id_dono"), rs.getString("titulo"), rs.getString("descricao"), rs.getDouble("valor_meta"), rs.getString("img"), rs.getDate("data_limite"), rs.getBoolean("eh_publico"));
			metaBean.setId(rs.getInt("id_meta"));
			rs.close();
			st.close();
			return metaBean;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
