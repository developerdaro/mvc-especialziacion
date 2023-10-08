package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Metas;

public interface MetasService {

	public Iterable <Metas> findAll();
	public Optional<Metas> findById(Integer  id);
	public Metas save(Metas metas);
	public void deleteById(Integer  id);
	
}
