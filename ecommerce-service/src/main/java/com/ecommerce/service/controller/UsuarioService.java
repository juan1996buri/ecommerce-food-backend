package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Usuario;
import com.ecommerce.dto.UsuarioDTO;
import com.ecommerce.repository.UsuarioRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class UsuarioService extends GenericCRUDServiceImpl<Usuario, UsuarioDTO> {

	@Autowired
	private UsuarioRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public Optional<Usuario> find(UsuarioDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public UsuarioDTO mapToDto(Usuario domain) {
		return mapper.map(domain, UsuarioDTO.class);
	}

	@Override
	public Usuario mapToDomain(UsuarioDTO dto) {
		return mapper.map(dto, Usuario.class);
	}

}
