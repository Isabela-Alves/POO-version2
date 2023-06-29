package org.exemplo.persistencia.database.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	private Integer id;
	@Column (name="nome")
	private String nome;
	@Column (name="email")
	private String email;
	@ManyToOne
    @JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public Cliente(Integer id, String nome, String email, Cliente p) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cliente = p;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	

	public Paciente getPaciente() {
		return cliente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.cliente = paciente;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Exame [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	

	
	
}
