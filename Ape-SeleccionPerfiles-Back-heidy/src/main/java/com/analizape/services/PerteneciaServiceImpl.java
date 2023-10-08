package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Pertenencia;
import com.analizape.repository.PertenenciaRepository;

@Service
public class PerteneciaServiceImpl implements PertenenciaService{

	@Autowired
	private PertenenciaRepository PerteneciaRepository;
	
	@Override
	public Iterable<Pertenencia> findAll() {
		// TODO Auto-generated method stub
		return PerteneciaRepository.findAll();
	}

	@Override
	public Optional<Pertenencia> findById(Integer id) {
		// TODO Auto-generated method stub
		return PerteneciaRepository.findById(id);
	}

	@Override
	public Pertenencia save(Pertenencia pertenencia) {
		// TODO Auto-generated method stub
		return PerteneciaRepository.save(pertenencia);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		PerteneciaRepository.deleteById(id);
	}

}
