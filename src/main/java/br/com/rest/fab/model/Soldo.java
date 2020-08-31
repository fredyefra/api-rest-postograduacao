package br.com.rest.fab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.rest.fab.util.EntityBase;

@XmlRootElement
@Entity
@Table(name="tb_soldo")
public class Soldo implements EntityBase, Serializable {

	private static final long serialVersionUID = 1L;
	private Long identificador;
	private String remuneracao;
    
	
    public Soldo() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	@Column(name="remuneracao")
	@NotNull
	public String getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(String remuneracao) {
		this.remuneracao = remuneracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		Soldo other = (Soldo) obj;
		return identificador != null && identificador.equals(other.getIdentificador());
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR **** " + this + identificador;
	}
	
}
