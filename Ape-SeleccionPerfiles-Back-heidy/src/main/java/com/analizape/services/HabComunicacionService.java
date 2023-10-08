package com.analizape.services;

import java.util.Optional;

import com.analizape.models.HabComuicacion;

public interface HabComunicacionService {


	public Iterable <HabComuicacion> findAll();
	public Optional<HabComuicacion> findById(Integer  id);
	public HabComuicacion save(HabComuicacion habComuicacion);
	public void deleteById(Integer  id);
	
}
