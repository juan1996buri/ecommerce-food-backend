package com.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ecommerce.common.ApiException;

@Service
public abstract class GenericCRUDServiceImpl<DOMAIN, DTO> implements GenericCrudService<DOMAIN, DTO> {

	@Autowired
	private JpaRepository<DOMAIN, Long> repository;

	@Override
	public DTO save(DTO dto) {
		Optional<DOMAIN> optional = find(dto);
		if (!optional.isPresent()) {
			DOMAIN domainObject = mapToDomain(dto);
			return mapToDto(repository.save(domainObject));
		} else {
			throw new ApiException(String.format("Registro %s ya existe en el sistema", dto));
		}
	}

	@Override
	public void update(DTO dto) {
		Optional<DOMAIN> optional = find(dto);
		if (!optional.isPresent()) {
			throw new ApiException(String.format("Registro %s no existe en el sistema", dto));
		} else {
			DOMAIN domainObject = mapToDomain(dto);
			repository.save(domainObject);
		}
	}

	@Override
	public List<DTO> findAll(DTO dto) {
		return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	@Override
	public void delete(DTO dto) {
		Optional<DOMAIN> optional = find(dto);
		if (!optional.isPresent()) {
			throw new ApiException(String.format("Registro %s no existe en el sistema", dto));
		} else {
			DOMAIN domainObject = mapToDomain(dto);
			repository.delete(domainObject);
		}

	}

	@Override
	public abstract DOMAIN mapToDomain(DTO dto);

}