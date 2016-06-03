package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Classe modelo referente a tabela funcionario
 * @author Lucas
 *
 */
@Entity
@Table(name="funcionario")
@SequenceGenerator(name="funcionario_id_seq" , sequenceName="funcionario_id_seq")
public class FuncionarioBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="nascimento")
	private String nascimento;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="pis")
	private String pis;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="departamento")
	private String departamento;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="rua")
	private String rua;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="numero")
	private String numero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "FuncionarioBean [id=" + id + ", nome=" + nome + ", email=" + email + ", sobrenome=" + sobrenome
				+ ", nascimento=" + nascimento + ", cpf=" + cpf + ", pis=" + pis + ", genero=" + genero
				+ ", departamento=" + departamento + ", senha=" + senha + ", cep=" + cep + ", rua=" + rua + ", estado="
				+ estado + ", cidade=" + cidade + ", bairro=" + bairro + ", numero=" + numero + "]";
	}

}