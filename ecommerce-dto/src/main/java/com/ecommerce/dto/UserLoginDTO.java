package com.ecommerce.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
	
	private String email;
	
	private String password;
	
	private String token;
	
	private RolesDTO roles;
}
