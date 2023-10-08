package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Experiencia;

public interface ExperienciaService {

	public Iterable <Experiencia> findAll();
	public Optional<Experiencia> findById(Integer  id);
	public Experiencia save(Experiencia experiencia);
	public void deleteById(Integer  id);
	
}
