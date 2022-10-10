package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.EspecificacionProducto;
import com.ecommerce.dto.EspecificacionProductoDTO;
import com.ecommerce.repository.ProductoDetalleRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class ProductoDetalleService extends GenericCRUDServiceImpl<EspecificacionProducto, EspecificacionProductoDTO> {

	@Autowired
	private ProductoDetalleRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public Optional<EspecificacionProducto> find(EspecificacionProductoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public EspecificacionProductoDTO mapToDto(EspecificacionProducto domain) {
		return mapper.map(domain, EspecificacionProductoDTO.class);
	}

	@Override
	public EspecificacionProducto mapToDomain(EspecificacionProductoDTO dto) {
		return mapper.map(dto, EspecificacionProducto.class);
	}

}
