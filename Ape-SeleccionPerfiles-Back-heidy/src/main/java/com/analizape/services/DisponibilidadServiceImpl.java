package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Disponibilidad;
import com.analizape.repository.DisponibilidadRepository;

@Service 
public class DisponibilidadServiceImpl implements DisponibilidadService{

	@Autowired
	private DisponibilidadRepository disponibilidadRepository;
	
	@Override
	public Iterable<Disponibilidad> findAll() {
		// TODO Auto-generated method stub
		return disponibilidadRepository.findAll();
	}

	@Override
	public Optional<Disponibilidad> findById(Integer id) {
		// TODO Auto-generated method stub
		return disponibilidadRepository.findById(id);
	}

	@Override
	public Disponibilidad save(Disponibilidad disponibilidad) {
		// TODO Auto-generated method stub
		return disponibilidadRepository.save(disponibilidad);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		disponibilidadRepository.deleteById(id);
	}

}
