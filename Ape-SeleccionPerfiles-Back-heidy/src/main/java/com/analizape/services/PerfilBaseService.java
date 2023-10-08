package com.analizape.services;

import java.util.Optional;

import com.analizape.models.PerfilBase;

public interface PerfilBaseService {

	public Iterable <PerfilBase> findAll();
	public Optional<PerfilBase> findById(Integer id);
	public PerfilBase save(PerfilBase perfilBase);
	public void deleteById(Integer id);
	
}
