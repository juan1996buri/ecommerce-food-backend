package com.ecommerce.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioDTO {

	private long id;

	private String email;

	private String password;

	private LocalDateTime fechaRegistro;

	private RolesDTO roles;

}
