package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Favorito;
import com.ecommerce.dto.FavoritoDTO;
import com.ecommerce.repository.FavoritoRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class FavoritoService extends GenericCRUDServiceImpl<Favorito, FavoritoDTO> {

	@Autowired
	private FavoritoRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public Optional<Favorito> find(FavoritoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public FavoritoDTO mapToDto(Favorito domain) {
		return mapper.map(domain, FavoritoDTO.class);
	}

	@Override
	public Favorito mapToDomain(FavoritoDTO dto) {
		return mapper.map(dto, Favorito.class);
	}

}
