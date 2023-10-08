package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Rol;

public interface RolService {

	public Iterable <Rol> findAll();
	public Optional<Rol> findById(Integer  id);
	public Rol save(Rol rol);
	public void deleteById(Integer  id);
	
}
