package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platillos")
public class Platillos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idPlatillo;
	
	@Column(name = "nombrePlatillo", nullable = false, length = 50)
	String nombrePlatillo;
	
	@Column(name = "precioPlatillo", nullable = false, length = 10)
	Integer precioPlatillo;
	

	public Integer getIdPlatillo() {
		return idPlatillo;
	}

	public void setIdPlatillo(Integer idPlatillo) {
		this.idPlatillo = idPlatillo;
	}

	public String getNombrePlatillo() {
		return nombrePlatillo;
	}

	public void setNombrePlatillo(String nombrePlatillo) {
		this.nombrePlatillo = nombrePlatillo;
	}

	public Integer getprecioPlatillo() {
		return precioPlatillo;
	}

	public void setprecioPlatillo(Integer precioPlatillo) {
		this.precioPlatillo = precioPlatillo;
	}
}