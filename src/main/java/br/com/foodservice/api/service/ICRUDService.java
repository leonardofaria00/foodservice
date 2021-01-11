package br.com.foodservice.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICRUDService<T, DTO> {

	public ResponseEntity<DTO> create(T t);

	public ResponseEntity<List<DTO>> listAll();

	public ResponseEntity<DTO> listById(Long id);

	public ResponseEntity<DTO> update(T t);

	public ResponseEntity<Void> deleteById(Long id);

	public List<DTO> toListDTO(List<T> t);

	public DTO toDTO(T t);
}
