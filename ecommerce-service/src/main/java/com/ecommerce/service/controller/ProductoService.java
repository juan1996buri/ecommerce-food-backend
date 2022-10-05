package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Producto;
import com.ecommerce.dto.ProductoDTO;
import com.ecommerce.repository.ProductoRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class ProductoService extends GenericCRUDServiceImpl<Producto, ProductoDTO> {

	@Autowired
	private ProductoRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public Optional<Producto> find(ProductoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ProductoDTO mapToDto(Producto domain) {
		return mapper.map(domain, ProductoDTO.class);
	}

	@Override
	public Producto mapToDomain(ProductoDTO dto) {
		return mapper.map(dto, Producto.class);
	}

}
