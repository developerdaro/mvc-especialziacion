package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Habilidades_tecnicas;
import com.analizape.repository.HabilidadesTecnicasRepository;

@Service 
public class HabilidadesTecnicasServiceImpl implements HabilidadesTecnicasService {

	@Autowired
	HabilidadesTecnicasRepository habilidadesTecnicasRepository;
	
	@Override
	public Iterable<Habilidades_tecnicas> findAll() {
		// TODO Auto-generated method stub
		return habilidadesTecnicasRepository.findAll();
	}

	@Override
	public Optional<Habilidades_tecnicas> findById(Integer id) {
		// TODO Auto-generated method stub
		return habilidadesTecnicasRepository.findById(id);
	}

	@Override
	public Habilidades_tecnicas save(Habilidades_tecnicas habilidadesTecnicas) {
		// TODO Auto-generated method stub
		return habilidadesTecnicasRepository.save(habilidadesTecnicas); 
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		habilidadesTecnicasRepository.deleteById(id);
		
	}

}
