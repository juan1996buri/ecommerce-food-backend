package com.ecommerce.dto;

import lombok.Data;

@Data
public class EspecificacionProductoDTO {
	
	private long id;
	
	private double precio;
	
	private String nombre;
	
	private String descripcion;
	
	private ProductoDTO producto;
	
	private Boolean estado_principal;
	
	private int stock;
}
