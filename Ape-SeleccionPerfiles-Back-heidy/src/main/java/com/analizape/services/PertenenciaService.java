package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Pertenencia;

public interface PertenenciaService {

	public Iterable <Pertenencia> findAll();
	public Optional<Pertenencia> findById(Integer  id);
	public Pertenencia save(Pertenencia pertenencia);
	public void deleteById(Integer  id);
}
