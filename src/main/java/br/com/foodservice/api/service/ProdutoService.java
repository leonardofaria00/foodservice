package br.com.foodservice.api.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.foodservice.api.dto.ProdutoDTO;
import br.com.foodservice.api.exception.FoodServiceException;
import br.com.foodservice.api.model.Produto;
import br.com.foodservice.api.repository.ProdutoRepository;

@Service
public class ProdutoService implements ICRUDService<Produto, ProdutoDTO> {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("unused")
	@Override
	public ResponseEntity<ProdutoDTO> create(Produto produto) {
		try {

			if (produto.getName().isEmpty() || produto.getName().isBlank()) {
				return ResponseEntity.badRequest().build();
			}

			if (produto.getPreco().isEmpty() || produto.getPreco().isBlank()) {
				return ResponseEntity.badRequest().build();
			}

			if (produto != null) {

				produto.setCreatedAt(OffsetDateTime.now());

				repository.save(produto);

				ProdutoDTO dto = toDTO(produto);

				return ResponseEntity.status(HttpStatus.CREATED).body(dto);
			}

		} catch (Exception e) {
			throw new FoodServiceException("Não foi possível cadastrar o Produto.");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Override
	public ResponseEntity<List<ProdutoDTO>> listAll() {
		try {

			List<Produto> produtos = repository.findAll();

			if (!produtos.isEmpty()) {

				List<ProdutoDTO> dto = toListDTO(produtos);

				return ResponseEntity.status(HttpStatus.OK).body(dto);
			}

		} catch (Exception e) {
			throw new FoodServiceException("Não foi possível encontrar o Produto.");
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Override
	public ResponseEntity<ProdutoDTO> listById(Long id) {
		try {

			Optional<Produto> optional = repository.findById(id);

			if (!optional.isEmpty()) {

				ProdutoDTO dto = toDTO(optional.get());

				return ResponseEntity.status(HttpStatus.OK).body(dto);
			}
		} catch (Exception e) {
			throw new FoodServiceException("Não foi possível encontrar o Produto.");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Override
	public ResponseEntity<ProdutoDTO> update(Produto produto) {
		try {

			Optional<Produto> optional = repository.findById(produto.getId());

			if (!optional.isEmpty()) {

				produto.setId(optional.get().getId());

				repository.save(produto);

				ProdutoDTO dto = toDTO(produto);

				return ResponseEntity.status(HttpStatus.OK).body(dto);
			}

		} catch (Exception e) {
			throw new FoodServiceException("Não foi possível alterar o Produto: " + produto.getName());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		try {
			Optional<Produto> optional = repository.findById(id);

			if (!optional.isEmpty()) {

				repository.delete(optional.get());

				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		} catch (Exception e) {
			throw new FoodServiceException("Não foi possível remover o Produto.");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@Override
	public List<ProdutoDTO> toListDTO(List<Produto> produtos) {
		return produtos.stream().map(produto -> toDTO(produto)).collect(Collectors.toList());
	}

	@Override
	public ProdutoDTO toDTO(Produto produto) {
		return modelMapper.map(produto, ProdutoDTO.class);
	}
}
