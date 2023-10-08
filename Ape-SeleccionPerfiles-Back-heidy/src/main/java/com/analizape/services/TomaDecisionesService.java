package com.analizape.services;

import java.util.Optional;

import com.analizape.models.TomadeDecisiones;

public interface TomaDecisionesService {

	public Iterable <TomadeDecisiones> findAll();
	public Optional<TomadeDecisiones> findById(Integer  id);
	public TomadeDecisiones save(TomadeDecisiones tomadeDecisiones);
	public void deleteById(Integer  id);
	
}
