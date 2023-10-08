package com.analizape.services;

import java.util.Optional;

import com.analizape.models.ConceptodeSiMismo;

public interface ConceptodeSiMismoService {

	public Iterable <ConceptodeSiMismo> findAll();
	public Optional<ConceptodeSiMismo> findById(Integer  id);
	public ConceptodeSiMismo save(ConceptodeSiMismo conceptodeSiMismo);
	public void deleteById(Integer  id);
	
}
