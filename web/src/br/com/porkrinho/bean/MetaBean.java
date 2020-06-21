package br.com.porkrinho.bean;

import java.util.Date;

public class MetaBean {
	private int idMeta;
	private int usuarioId;
	private String titulo;
	private String descricao;
	private Double valorAtual;
	private Double valorMeta;
	private String pathImg;
	private Date dataLimite;
	private boolean ehPublico;
	
	public MetaBean(int usuarioId, String titulo, String descricao, Double valorMeta, Double valor, String pathImg,
			Date dataLimite, boolean ehPublico) {
		super();
		this.usuarioId = usuarioId;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valorMeta = valorMeta;
		this.valorAtual = valor;
		this.pathImg = pathImg;
		this.dataLimite = dataLimite;
		this.ehPublico = ehPublico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(Double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public Double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(Double valorMeta) {
		this.valorMeta = valorMeta;
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public Date getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Date dataLimite) {
		this.dataLimite = dataLimite;
	}

	public boolean getEhPublico() {
		return ehPublico;
	}

	public void setEhPublico(boolean ehPublico) {
		this.ehPublico = ehPublico;
	}

	public int getId() {
		return idMeta;
	}
	public void setId(int idMeta) {
		this.idMeta = idMeta;
	}

	public int getUsuarioId() {
		return usuarioId;
	}
	
}