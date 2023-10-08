package com.analizape.services;

import java.util.Optional;

import com.analizape.models.Planeacion_organizacion;

public interface PlaneacionyOrganizacionService {


	public Iterable <Planeacion_organizacion> findAll();
	public Optional<Planeacion_organizacion> findById(Integer  id);
	public Planeacion_organizacion save(Planeacion_organizacion planeacion_organizacion);
	public void deleteById(Integer  id);
	
}
