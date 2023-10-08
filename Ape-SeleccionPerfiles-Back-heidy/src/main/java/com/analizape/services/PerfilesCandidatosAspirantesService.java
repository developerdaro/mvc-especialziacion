package com.analizape.services;

import java.util.Optional;

import com.analizape.models.PerfilesCandidatosAspirantes;

public interface PerfilesCandidatosAspirantesService {
	
	public Iterable <PerfilesCandidatosAspirantes> findAll();
	public Optional<PerfilesCandidatosAspirantes> findById(Integer  id);
	public PerfilesCandidatosAspirantes save(PerfilesCandidatosAspirantes perfilesCandidatosAspirantes);
	public void deleteById(Integer  id);

}
