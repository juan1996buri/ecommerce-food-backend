package com.ecommerce.dto;

import lombok.Data;

@Data
public class ProductoDTO {

	private long id;

	private CategoriaDTO categoria;

	private String nombre;

	private double precio;

	private int stock;

	private String imagen;
}
