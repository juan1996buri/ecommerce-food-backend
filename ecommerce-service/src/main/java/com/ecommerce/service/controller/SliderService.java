package com.ecommerce.service.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Slider;
import com.ecommerce.dto.SliderDTO;
import com.ecommerce.repository.SliderRepository;
import com.ecommerce.service.GenericCRUDServiceImpl;

@Service
public class SliderService extends GenericCRUDServiceImpl<Slider, SliderDTO> {

	@Autowired
	private SliderRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public Optional<Slider> find(SliderDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public SliderDTO mapToDto(Slider domain) {
		return mapper.map(domain, SliderDTO.class);
	}

	@Override
	public Slider mapToDomain(SliderDTO dto) {
		return mapper.map(dto, Slider.class);
	}

}
