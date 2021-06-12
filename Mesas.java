package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mesas")
public class Mesas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idMesas;
	
	@Column(name = "tipoMesa", nullable = false, length = 50)
	String tipoMesa;
	
	@Column(name = "numeroSillas", nullable = false, length = 15)
	Integer numeroSillas;
	

	public Integer getIdMesas() {
		return idMesas;
	}

	public void setIdMesas(Integer idMesas) {
		this.idMesas = idMesas;
	}

	public String getTipoMesa() {
		return tipoMesa;
	}

	public void setTipoMesa(String tipoMesa) {
		this.tipoMesa = tipoMesa;
	}

	public Integer getNumeroSillas() {
		return numeroSillas;
	}

	public void setNumeroSillas(Integer	 numeroSillas) {
		this.numeroSillas = numeroSillas;
	}
}