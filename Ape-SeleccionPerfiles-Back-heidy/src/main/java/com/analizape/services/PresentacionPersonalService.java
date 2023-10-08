package com.analizape.services;

import java.util.Optional;

import com.analizape.models.PresentacionPersonal;

public interface PresentacionPersonalService {

	public Iterable <PresentacionPersonal> findAll();
	public Optional<PresentacionPersonal> findById(Integer  id);
	public PresentacionPersonal save(PresentacionPersonal presentacionPersonal);
	public void deleteById(Integer  id);
	
}
