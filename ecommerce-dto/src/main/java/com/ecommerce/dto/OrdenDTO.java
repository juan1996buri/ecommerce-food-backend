package com.ecommerce.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdenDTO {

	private long id;

	private String direccion;

	private LocalDateTime fechaRegistro;

	private Boolean estado;

	private String numeroOrden;
}
