package com.service.carro.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.carro.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	public List<Carro> findByUserId(int userId);

}
