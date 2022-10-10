package com.ecommerce.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.common.dto.ApiResponseDTO;
import com.ecommerce.domain.Usuario;
import com.ecommerce.dto.RolesDTO;
import com.ecommerce.dto.UserLoginDTO;
import com.ecommerce.dto.UsuarioDTO;
import com.ecommerce.security.JwtTokenUtil;
import com.ecommerce.service.controller.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwUtil;

	@PostMapping("/registrar")
	public ResponseEntity<Object> save(@RequestBody UsuarioDTO dto) {
		RolesDTO role = new RolesDTO();
		role.setId(2);
		dto.setRoles(role);
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		dto.setFechaRegistro(LocalDateTime.now());
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> respuesta() {
		List<UsuarioDTO> optional = service.findAll(new UsuarioDTO());
		if (!optional.isEmpty()) {
			return new ResponseEntity<>(new ApiResponseDTO<>(true, optional), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(new ApiResponseDTO<>(true, optional), HttpStatus.NOT_FOUND);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserLoginDTO userLogin) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword()));
			Usuario user = (Usuario) authentication.getPrincipal();
			String token = jwUtil.generateAccessToken(user);
			userLogin.setPassword("");
			userLogin.setToken(token);
			RolesDTO rolesDTO=new RolesDTO();
			rolesDTO.setId(user.getRoles().getId());
			rolesDTO.setNombre(user.getRoles().getNombre());
			userLogin.setRoles(rolesDTO);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, userLogin), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}