package com.paul.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/***
 * Define el tipo de prenda / artículo como camisa, pantalón, vestido, etc
 * @author PM
 *
 */
@Entity
public class Tipo  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true)
	// @GeneratedValue(generator = "org.hibernate.id.Assigned")
	private String clave;
	
	@Column(length = 50, nullable = false)
	private String descripcion;

	public Tipo() {}
	
	public Tipo(String clave, String descripcion) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
}