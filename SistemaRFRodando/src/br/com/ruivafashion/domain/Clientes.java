package br.com.ruivafashion.domain;

public class Clientes {
	
	private Integer idclientes;
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private String email;
	private String datanascimento;
	private String endereco;
	private String cep;
	private String cidade;	
	private String bairro;
	private String estado;
	private String pontoreferencia;
	private String telefone;
	private String telefone2;
	private String senha;
	
	
	
	public Integer getIdclientes() {
		return idclientes;
	}




	public void setIdclientes(Integer idclientes) {
		this.idclientes = idclientes;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public String getRg() {
		return rg;
	}




	public void setRg(String rg) {
		this.rg = rg;
	}




	public String getSexo() {
		return sexo;
	}




	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getDatanascimento() {
		return datanascimento;
	}




	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}




	public String getEndereco() {
		return endereco;
	}




	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}




	public String getCep() {
		return cep;
	}




	public void setCep(String cep) {
		this.cep = cep;
	}




	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
	}




	public String getBairro() {
		return bairro;
	}




	public void setBairro(String bairro) {
		this.bairro = bairro;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public String getPontoreferencia() {
		return pontoreferencia;
	}




	public void setPontoreferencia(String pontoreferencia) {
		this.pontoreferencia = pontoreferencia;
	}




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	public String getTelefone2() {
		return telefone2;
	}




	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	@Override
	public String toString() {
		String saida = idclientes + " - " + nome + "-" + cpf;
		return saida;
	}
	
	


}
