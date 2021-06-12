package edu.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordenes")
public class Ordenes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idOrden;
	@ManyToOne
	@JoinColumn(name="idPlatillo",nullable = false, foreignKey = @ForeignKey(name = "ordenes_platillos"))
	Platillos platillos;
	@ManyToOne
	@JoinColumn(name="idMesero",nullable = false, foreignKey = @ForeignKey(name = "ordenes_meseros"))
	Meseros meseros;
	@ManyToOne
	@JoinColumn(name="idMesas",nullable = false, foreignKey = @ForeignKey(name = "ordenes_mesas"))
	Mesas mesas;
	@Column(name = "fechaOrden", nullable = false, length = 20)
	String fechaOrden;
	
	
	public Integer getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}
	public Platillos getPlatillos() {
		return platillos;
	}
	public void setPlatillos(Platillos platillos) {
		this.platillos = platillos;
	}
	public Meseros getMeseros(){
		return meseros;
	}
	public void setMeseros(Meseros meseros) {
		this.meseros = meseros;
	}
	public Mesas getMesas() {
		return mesas;
	}
	public void setMesas(Mesas mesas) {
		this.mesas = mesas;
	}
	public String getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}	
}