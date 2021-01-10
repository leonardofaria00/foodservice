package br.com.foodservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foodservice.api.service.CardapioService;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

	@Autowired
	private CardapioService service;

}
