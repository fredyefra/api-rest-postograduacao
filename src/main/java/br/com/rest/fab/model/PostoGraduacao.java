package br.com.rest.fab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.rest.fab.util.EntityBase;

@XmlRootElement
@Entity
@Table(name="tb_posto_graduacao_fab")
public class PostoGraduacao implements EntityBase,  Serializable {

	private static final long serialVersionUID = 1L;

	private Long identificador;
	private String dsPostoGraduacao;
	private String sgPostoGraduacao;
	private Soldo fkSoldo;
	private Patente patente;
	private ImagemInsigniaFAB fkInsignia;
    private byte[] insignia;
 
	public PostoGraduacao() {}		

	public PostoGraduacao(Patente patente, Soldo fkSoldo) {
		this.patente = patente;
		this.fkSoldo = fkSoldo;
		//this.insigniaFAB = insigniaFAB;
	}		


	public PostoGraduacao(Long identificador, String dsPostoGraduacao, String sgPostoGraduacao, Patente patente, Soldo fkSoldo) { 
		this.identificador =identificador; 
		this.dsPostoGraduacao = dsPostoGraduacao;
		this.sgPostoGraduacao = sgPostoGraduacao; 
		this.patente = patente;
		this.fkSoldo = fkSoldo;
		//this.insigniaFAB = insigniaFAB; 
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="identificador")
	@Override
	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	@Column(name="dsPostoGraduacao")
	@NotNull
	public String getDsPostoGraduacao() {
		return dsPostoGraduacao;
	}

	public void setDsPostoGraduacao(String dsPostoGraduacao) {
		this.dsPostoGraduacao = dsPostoGraduacao;
	}

	@Column(name="sgPostoGraduacao")
	@NotNull
	public String getSgPostoGraduacao() {
		return sgPostoGraduacao;
	}

	public void setSgPostoGraduacao(String sgPostoGraduacao) {
		this.sgPostoGraduacao = sgPostoGraduacao;
	}

	@ManyToOne
	@JoinColumn(name = "fkSoldo")
	public Soldo getFkSoldo() {
		return fkSoldo;
	}

	public void setFkSoldo(Soldo fkSoldo) {
		this.fkSoldo = fkSoldo;
	}

	@ManyToOne
	@JoinColumn(name = "fkPatente")
	public Patente getPatente() {
		return patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}


	/*@ManyToOne
	@JoinColumn(name = "fkInsignia")
	public ImagemInsigniaFAB getInsigniaFAB() { 
		return insigniaFAB; 
	}

	public void setInsigniaFAB(ImagemInsigniaFAB insigniaFAB) { 
		this.insigniaFAB = insigniaFAB; 
	}*/

	
	 @Lob
	 @Column(name ="insignia") 
	 public byte[] getInsignia() { 
		 return insignia; 
	 }
	  
	 public void setInsignia(byte[] insignia) { 
		 this.insignia = insignia; 
	 }
	 
	@ManyToOne
	@JoinColumn(name = "fkInsignia") 
	public ImagemInsigniaFAB getFkInsignia() {
		return fkInsignia;
	}
	
	public void setFkInsignia(ImagemInsigniaFAB fkInsignia) {
		this.fkInsignia = fkInsignia;
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
		PostoGraduacao other = (PostoGraduacao) obj;
		return identificador != null && identificador.equals(other.getIdentificador());
	}

	@Override
	public String toString() {
		return "**** IDENTIFICADOR WEB SERVICE **** " + this + identificador;
	}
}