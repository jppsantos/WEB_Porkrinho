package br.com.porkrinho.bean;

public class UsuarioBean {
	private int idUsuario;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String senha;
	private String telefone;
	private int idBanco;
	private String pathImg;
	
	public static UsuarioBean User;;
	
	public UsuarioBean(String nome, String sobrenome, String cpf, String email, String senha,
			String telefone, int idBanco, String pathImg) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.idBanco = idBanco;
		this.pathImg = pathImg;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cof) {
		this.cpf = cof;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBancp) {
		this.idBanco = idBancp;
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}
	
}
