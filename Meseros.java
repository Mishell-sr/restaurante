package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meseros")
public class Meseros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idMesero;
	
	@Column(name = "nombresMesero", nullable = false, length = 30)
	String nombresMesero;
	
	@Column(name = "apellidosMesero", nullable = false, length = 30)
	String apellidosMesero;
	
	@Column(name = "descripcion", nullable = false, length = 50)
	String descripcion;

	public Integer getIdMesero() {
		return idMesero;
	}

	public void setIdMesero(Integer idMesero) {
		this.idMesero = idMesero;
	}

	public String getNombresMesero() {
		return nombresMesero;
	}

	public void setNombresMesero(String nombresMesero) {
		this.nombresMesero = nombresMesero;
	}

	public String getApellidosMesero() {
		return apellidosMesero;
	}

	public void setApellidosMesero(String apellidosMesero) {
		this.apellidosMesero = apellidosMesero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}