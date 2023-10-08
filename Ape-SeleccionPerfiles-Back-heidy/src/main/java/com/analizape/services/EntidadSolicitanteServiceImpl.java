package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.EntidadSolicitante;
import com.analizape.repository.EntidadSolicitanteRepository;

@Service
public class EntidadSolicitanteServiceImpl implements EntidadSolcitanteService{

	@Autowired 
	private EntidadSolicitanteRepository entidadSolicitanteRepository;
	
	@Override
	public Iterable<EntidadSolicitante> findAll() {
		// TODO Auto-generated method stub
		return entidadSolicitanteRepository.findAll();
	}

	@Override
	public Optional<EntidadSolicitante> findById(Integer id) {
		// TODO Auto-generated method stub
		return entidadSolicitanteRepository.findById(id);
	}

	@Override
	public EntidadSolicitante save(EntidadSolicitante entidadSolicitante) {
		// TODO Auto-generated method stub
		return entidadSolicitanteRepository.save(entidadSolicitante);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		entidadSolicitanteRepository.deleteById(id);
	}

}
