package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.HabilidadesSociales;
import com.analizape.repository.HabilidadesSocialesRepository;

@Service 
public class HabilidadesSocialesServiceImpl implements HabilidadesSocialesService{

	@Autowired
	private HabilidadesSocialesRepository habilidadesSocialesRepository;
	
	@Override
	public Iterable<HabilidadesSociales> findAll() {
		// TODO Auto-generated method stub
		return habilidadesSocialesRepository.findAll();
	}

	@Override
	public Optional<HabilidadesSociales> findById(Integer id) {
		// TODO Auto-generated method stub
		return habilidadesSocialesRepository.findById(id);
	}

	@Override
	public HabilidadesSociales save(HabilidadesSociales habilidadesSociales) {
		// TODO Auto-generated method stub
		return habilidadesSocialesRepository.save(habilidadesSociales);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		habilidadesSocialesRepository.deleteById(id);
	}

}
