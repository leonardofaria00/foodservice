package br.com.foodservice.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICRUDController<T, DTO, ID> {

	public ResponseEntity<List<DTO>> listAll();

	public ResponseEntity<DTO> listById(Long id);

	public ResponseEntity<DTO> create(T t);

	public ResponseEntity<DTO> update(T t);

	public ResponseEntity<Void> deleteById(Long id);
}
