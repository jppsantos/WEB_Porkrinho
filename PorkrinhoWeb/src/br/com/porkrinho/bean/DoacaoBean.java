package br.com.porkrinho.bean;

import java.sql.Date;

public class DoacaoBean {
	private Integer idDoacao;
	private Integer idMeta;
	private Integer idUsuario;
	private Date data;
	private Double valor;
	private String mensagem;
	private Boolean ehAnonimo;
	private Boolean ehNotificado;
	
	
	
	public DoacaoBean(Integer idMeta, Integer idUsuario, Date data, Double valor, String mensagem,
			Boolean ehAnonimo, Boolean ehNotificado) {
		super();
		this.idMeta = idMeta;
		this.idUsuario = idUsuario;
		this.data = data;
		this.valor = valor;
		this.mensagem = mensagem;
		this.ehAnonimo = ehAnonimo;
		this.ehNotificado = ehNotificado;
	}
	
	public Integer getIdDoacao() {
		return idDoacao;
	}
	public void setIdDoacao(Integer idDoacao) {
		this.idDoacao = idDoacao;
	}
	public Integer getIdMeta() {
		return idMeta;
	}
	public void setIdMeta(Integer idMeta) {
		this.idMeta = idMeta;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Boolean getEhAnonimo() {
		return ehAnonimo;
	}
	public void setEhAnonimo(Boolean ehAnonimo) {
		this.ehAnonimo = ehAnonimo;
	}
	public Boolean getEhNotificado() {
		return ehNotificado;
	}
	public void setEhNotificado(Boolean ehNotificado) {
		this.ehNotificado = ehNotificado;
	}
	
	

}
