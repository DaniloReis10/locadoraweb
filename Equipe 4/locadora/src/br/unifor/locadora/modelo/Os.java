package br.unifor.locadora.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe Model de OS
 * @author Grupo4
 *
 */
@Entity
public class Os implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String sumario;
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalizadoEm;
	
//	@Column(length=1000)
//	private String comentario;
//	
	@OneToOne(cascade=CascadeType.ALL)
	private Carro carro;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario responsavel;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario cliente;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.FECHADO;
	
	@OneToMany(cascade=CascadeType.ALL, 
			orphanRemoval=true, mappedBy="os")
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	/**
	 * Dados para o Status de Entrega
	 * 
	 */
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario responsavelEntrega;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEntrega;
	private String tanqueEntrega;
	private double kmEntrega;
	

	
	
	public Usuario getResponsavelEntrega() {
		return responsavelEntrega;
	}

	public void setResponsavelEntrega(Usuario responsavelEntrega) {
		this.responsavelEntrega = responsavelEntrega;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getTanqueEntrega() {
		return tanqueEntrega;
	}

	public void setTanqueEntrega(String tanqueEntrega) {
		this.tanqueEntrega = tanqueEntrega;
	}

	public double getKmEntrega() {
		return kmEntrega;
	}

	public void setKmEntrega(double kmEntrega) {
		this.kmEntrega = kmEntrega;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

//	public String getComentario() {
//		return comentario;
//	}
//
//	public void setComentario(String comentario) {
//		this.comentario = comentario;
//	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public Date getFinalizadoEm() {
		return finalizadoEm;
	}

	public void setFinalizadoEm(Date finalizadoEm) {
		this.finalizadoEm = finalizadoEm;
	}

//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Os other = (Os) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//teste
	public void comenta(Comentario comentario){
		comentario.setCriadoEm(new Date());
		comentario.setOs(this);
		this.comentarios.add(comentario);
	}
	
	//teste
	public void entrega(Comentario comentario){
		comentario.setCriadoEm(new Date());
		comentario.setOs(this);
		this.comentarios.add(comentario);
		this.status = Status.ABERTO;
	}
	
}
