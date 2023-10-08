package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Liderazgo;

public interface LiderazgoService {

	public Iterable <Liderazgo> findAll();
	public Optional<Liderazgo> findById(Integer  id);
	public Liderazgo save(Liderazgo liderazgo);
	public void deleteById(Integer  id);
	
}
