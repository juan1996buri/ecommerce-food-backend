package com.ecommerce.dto;

import lombok.Data;

@Data
public class OrdenDetalleDTO {

	private long id;

	private OrdenDTO orden;

	private EspecificacionProductoDTO especificacionProducto;

	private double precio;
	
	private int cantidad;
}
