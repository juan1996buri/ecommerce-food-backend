package com.ecommerce.dto;

import lombok.Data;

@Data
public class OrdenDetalleDTO {

	private long id;

	private OrdenDTO orden;

	private ProductoDTO producto;

	private double precio;
	
	private int cantidad;
}
