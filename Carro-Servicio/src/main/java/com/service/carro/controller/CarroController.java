package com.service.carro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.carro.entity.Carro;
import com.service.carro.service.CarroServicio;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	CarroServicio carroServicio;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Carro>> litarCarro(){
		List<Carro> listaCarro = carroServicio.listar();
		if(listaCarro.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(listaCarro);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Carro> buscarCarro(@PathVariable("id") int id){
		Carro carro = carroServicio.buscarCarro(id);
		if(carro == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(carro);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Carro> crearCarro(@RequestBody Carro carro){
		return new ResponseEntity<Carro>(carroServicio.crearCarro(carro),HttpStatus.CREATED);
	}
	
	@GetMapping("/listarUsuario/{id}")
	public ResponseEntity<List<Carro>> buscarUsuario(@PathVariable("id") int id){
		List<Carro> carro = carroServicio.buscarUsuario(id);
		return ResponseEntity.ok(carro);
	}

}
