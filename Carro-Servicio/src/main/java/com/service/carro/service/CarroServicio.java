package com.service.carro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.carro.entity.Carro;
import com.service.carro.entity.repository.CarroRepository;

@Service
public class CarroServicio {

	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> listar(){
		List<Carro> listaCarro = carroRepository.findAll();
		listaCarro.sort((Carro c1,Carro a2)-> c1.getId()-a2.getId());
		return listaCarro;
	}
	
	public Carro crearCarro(Carro carro) {
		return carroRepository.save( carro);
	}
	
	public Carro buscarCarro(int id) {
		return carroRepository.findById(id).orElse(null);
	}
	
	public List<Carro> buscarUsuario(int id) {
		return carroRepository.findByUserId(id);
	}
	
	
}
