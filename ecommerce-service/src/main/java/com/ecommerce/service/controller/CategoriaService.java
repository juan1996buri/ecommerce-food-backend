package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Categoria;
import com.ecommerce.dto.CategoriaDTO;
import com.ecommerce.repository.CategoriaRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class CategoriaService extends GenericCRUDServiceImpl<Categoria, CategoriaDTO> {

	@Autowired
	private CategoriaRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public Optional<Categoria> find(CategoriaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public CategoriaDTO mapToDto(Categoria domain) {
		return mapper.map(domain, CategoriaDTO.class);
	}

	@Override
	public Categoria mapToDomain(CategoriaDTO dto) {
		return mapper.map(dto, Categoria.class);
	}

}
