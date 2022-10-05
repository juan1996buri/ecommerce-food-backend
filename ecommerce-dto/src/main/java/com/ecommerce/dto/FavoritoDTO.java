package com.ecommerce.dto;

import lombok.Data;

@Data
public class FavoritoDTO {

	private long id;

	private ClienteDTO cliente;

	private Boolean estado;
}
