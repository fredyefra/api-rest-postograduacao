package br.com.rest.fab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.rest.fab.util.EntityBase;


@XmlRootElement
@Entity
@Table(name="tb_imagem_insignia_fab")
public class ImagemInsigniaFAB implements EntityBase, Serializable {

	private static final long serialVersionUID = 1L;
	private Long identificador;
	private byte[] insignia;
	private String url;
	
	public ImagemInsigniaFAB() {}
	
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
	
	@Lob
	@Column(name ="insignia")
	public byte[] getInsignia() {
		return insignia;
	}
	
	public void setInsignia(byte[] insignia) {
		this.insignia = insignia;
	}

	@Column(name ="url")
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	/*
	 * @Override public String toString() { return "**** IDENTIFICADOR **** " + this
	 * + identificador; }
	 */
}