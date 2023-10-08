package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Disponibilidad;

public interface DisponibilidadService {

	public Iterable <Disponibilidad> findAll();
	public Optional<Disponibilidad> findById(Integer  id);
	public Disponibilidad save(Disponibilidad disponibilidad);
	public void deleteById(Integer  id);
}
