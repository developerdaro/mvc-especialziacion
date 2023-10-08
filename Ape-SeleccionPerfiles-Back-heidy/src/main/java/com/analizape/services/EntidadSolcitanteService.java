package com.analizape.services;

import java.util.Optional;

import com.analizape.models.EntidadSolicitante;

public interface EntidadSolcitanteService {

	public Iterable <EntidadSolicitante> findAll();
	public Optional<EntidadSolicitante> findById(Integer  id);
	public EntidadSolicitante save(EntidadSolicitante entidadSolicitante);
	public void deleteById(Integer  id);
}
