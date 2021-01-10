package br.com.foodservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.foodservice.api.model.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
