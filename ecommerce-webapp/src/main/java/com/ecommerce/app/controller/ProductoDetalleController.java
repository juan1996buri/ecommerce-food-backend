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
import com.ecommerce.domain.EspecificacionProducto;
import com.ecommerce.dto.EspecificacionProductoDTO;
import com.ecommerce.service.controller.ProductoDetalleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/productoDetalle")
public class ProductoDetalleController {

	@Autowired
	private ProductoDetalleService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody EspecificacionProductoDTO dto) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.save(dto)), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody EspecificacionProductoDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<EspecificacionProductoDTO> list = service.findAll(new EspecificacionProductoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<EspecificacionProductoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable long id) {
		EspecificacionProductoDTO dto = new EspecificacionProductoDTO();
		dto.setId(id);
		Optional<EspecificacionProducto> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<EspecificacionProducto> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		EspecificacionProductoDTO dto = new EspecificacionProductoDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
	}
}
