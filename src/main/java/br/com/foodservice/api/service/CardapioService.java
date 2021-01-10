package br.com.foodservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foodservice.api.repository.CardapioRepository;

@Service
public class CardapioService {

	@Autowired
	private CardapioRepository repository;

}
