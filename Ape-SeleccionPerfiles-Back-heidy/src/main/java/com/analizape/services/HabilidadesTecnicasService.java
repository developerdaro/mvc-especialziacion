package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Habilidades_tecnicas;

public interface HabilidadesTecnicasService {

	public Iterable <Habilidades_tecnicas> findAll();
	public Optional<Habilidades_tecnicas> findById(Integer  id);
	public Habilidades_tecnicas save(Habilidades_tecnicas habilidadesTecnicas);
	public void deleteById(Integer  id);
}

