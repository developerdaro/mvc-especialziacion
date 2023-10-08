package com.analizape.services;

import java.util.Optional;

import com.analizape.models.NivelEstudios;

public interface NivelEstudiosService {

	public Iterable <NivelEstudios> findAll();
	public Optional<NivelEstudios> findById(Integer  id);
	public NivelEstudios save(NivelEstudios nivelEstudios);
	public void deleteById(Integer  id);
	
}
