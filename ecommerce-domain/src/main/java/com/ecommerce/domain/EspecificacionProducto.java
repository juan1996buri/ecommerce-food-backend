package com.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="especificacion_producto" )
public class EspecificacionProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column()
	private double precio;
	
	@Column()
	private String nombre;
	
	@Column()
	private String descripcion;
	
	@Column()
	private int stock;
	
	@Column()
	private Boolean estado_principal;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
}
