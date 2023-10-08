package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Iniciativa;

public interface IniciativaService {

	public Iterable <Iniciativa> findAll();
	public Optional<Iniciativa> findById(Integer  id);
	public Iniciativa save(Iniciativa iniciativa);
	public void deleteById(Integer  id);
	
}
