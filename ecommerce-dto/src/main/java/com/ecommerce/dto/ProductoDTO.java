package com.ecommerce.dto;

import lombok.Data;

@Data
public class ProductoDTO {

	private long id;

	private CategoriaDTO categoria;

	private String nombre;

	private String imagen;
}
