package br.com.foodservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodservice.api.dto.ProdutoDTO;
import br.com.foodservice.api.model.Produto;
import br.com.foodservice.api.service.ProdutoService;

@RestController
@RequestMapping(path = "/foodservice")
public class ProdutoController implements ICRUDController<Produto, ProdutoDTO, Long> {

	@Autowired
	private ProdutoService service;

	@Override
	@GetMapping(path = "/produto")
	public ResponseEntity<List<ProdutoDTO>> listAll() {
		return service.listAll();
	}

	@Override
	@GetMapping(path = "/produto/{id}")
	public ResponseEntity<ProdutoDTO> listById(@PathVariable Long id) {
		return service.listById(id);
	}

	@Override
	@PostMapping(path = "/produto")
	public ResponseEntity<ProdutoDTO> create(@Validated @RequestBody Produto produto) {
		return service.create(produto);
	}

	@Override
	@PutMapping(path = "/produto")
	public ResponseEntity<ProdutoDTO> update(@RequestBody Produto produto) {
		return service.update(produto);
	}

	@Override
	@DeleteMapping(path = "/produto/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
}
