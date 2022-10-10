package com.ecommerce.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.common.dto.ApiResponseDTO;
import com.ecommerce.domain.Orden;
import com.ecommerce.dto.OrdenDTO;
import com.ecommerce.service.controller.OrdenService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/orden")
public class OrdenController {

	@Autowired
	private OrdenService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody OrdenDTO dto) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.save(dto)), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody OrdenDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<OrdenDTO> list = service.findAll(new OrdenDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<OrdenDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable long id) {
		OrdenDTO dto = new OrdenDTO();
		dto.setId(id);
		Optional<Orden> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<Orden> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		OrdenDTO dto = new OrdenDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
	}
}
