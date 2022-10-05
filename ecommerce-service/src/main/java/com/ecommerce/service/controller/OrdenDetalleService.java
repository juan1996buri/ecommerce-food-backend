package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.OrdenDetalle;
import com.ecommerce.dto.OrdenDetalleDTO;
import com.ecommerce.repository.OrdenDetalleRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class OrdenDetalleService extends GenericCRUDServiceImpl<OrdenDetalle, OrdenDetalleDTO>{

	@Autowired
	private OrdenDetalleRepository repository;
	
	private ModelMapper mapper=new ModelMapper();

	@Override
	public Optional<OrdenDetalle> find(OrdenDetalleDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public OrdenDetalleDTO mapToDto(OrdenDetalle domain) {
		return mapper.map(domain, OrdenDetalleDTO.class);
	}

	@Override
	public OrdenDetalle mapToDomain(OrdenDetalleDTO dto) {
		return mapper.map(dto, OrdenDetalle.class);
	}

}
