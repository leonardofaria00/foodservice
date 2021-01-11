package br.com.foodservice.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

	private Long id;
	private String name;
	private String preco;
}
