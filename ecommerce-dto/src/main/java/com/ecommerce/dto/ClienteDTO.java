package com.ecommerce.dto;

import lombok.Data;

@Data
public class ClienteDTO {
	
	private long id;
	
	private String nombre;
	
	private String apellido;
	
	private UsuarioDTO usuario;
}
