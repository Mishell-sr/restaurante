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
@Table(name="estado_Orden")
public class EstadoOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idestado_Orden;
	@ManyToOne
	@JoinColumn(name="idOrden",nullable = false, foreignKey = @ForeignKey(name = "estado_Orden_Ordenes"))
	Ordenes ordenes;
	@ManyToOne
	@JoinColumn(name="idCliente",nullable = false, foreignKey = @ForeignKey(name = "estado_Orden_clientes"))
	Clientes clientes;
	@Column(name = "Descripcion", nullable = false, length = 40)
	String descripcion;
	
	
	public Integer getIdestado_Orden() {
		return idestado_Orden;
	}
	public void setIdEstado_Orden(Integer idestado_Orden) {
		this.idestado_Orden = idestado_Orden;
	}
	public Ordenes getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(Ordenes ordenes) {
		this.ordenes = ordenes;
	}
	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion (String descripcion) {
		this.descripcion = descripcion;
	}
	
}