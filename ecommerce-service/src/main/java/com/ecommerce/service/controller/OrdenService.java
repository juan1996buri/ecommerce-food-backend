package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Orden;
import com.ecommerce.dto.OrdenDTO;
import com.ecommerce.repository.OrdenRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class OrdenService extends GenericCRUDServiceImpl<Orden, OrdenDTO> {

	@Autowired
	private OrdenRepository repository;
	
	private ModelMapper mapper=new ModelMapper();

	@Override
	public Optional<Orden> find(OrdenDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public OrdenDTO mapToDto(Orden domain) {
		return mapper.map(domain, OrdenDTO.class);
	}

	@Override
	public Orden mapToDomain(OrdenDTO dto) {
		return mapper.map(dto, Orden.class);
	}

}
