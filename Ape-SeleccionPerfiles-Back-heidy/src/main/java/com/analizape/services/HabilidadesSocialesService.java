package com.analizape.services;

import java.util.Optional;

import com.analizape.models.HabilidadesSociales;

public interface HabilidadesSocialesService {

	public Iterable <HabilidadesSociales> findAll();
	public Optional<HabilidadesSociales> findById(Integer  id);
	public HabilidadesSociales save(HabilidadesSociales habilidadesSociales);
	public void deleteById(Integer  id);
	
}
