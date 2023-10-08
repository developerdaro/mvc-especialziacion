package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Entrevistas;
import com.analizape.models.user;

public interface EntrevistasService {

	public Iterable <Entrevistas> findAll();
	public Optional<Entrevistas> findById(Integer id);
	public Entrevistas save(Entrevistas entrevistas);
	public void deleteById(Integer id);
	
}
