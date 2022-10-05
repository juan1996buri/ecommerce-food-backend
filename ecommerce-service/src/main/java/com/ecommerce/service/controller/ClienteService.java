package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Cliente;
import com.ecommerce.dto.ClienteDTO;
import com.ecommerce.repository.ClienteRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class ClienteService extends GenericCRUDServiceImpl<Cliente, ClienteDTO> {
	
	@Autowired
	private ClienteRepository repository;
	
	private ModelMapper mapper=new ModelMapper();

	@Override
	public Optional<Cliente> find(ClienteDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ClienteDTO mapToDto(Cliente domain) {
		return mapper.map(domain, ClienteDTO.class);
	}

	@Override
	public Cliente mapToDomain(ClienteDTO dto) {
		return mapper.map(dto, Cliente.class);
	}

}
