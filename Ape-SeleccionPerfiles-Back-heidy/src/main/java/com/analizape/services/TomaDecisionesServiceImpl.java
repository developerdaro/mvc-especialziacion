package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.TomadeDecisiones;
import com.analizape.repository.RolRepository;
import com.analizape.repository.TomaDecisionesRepository;

@Service
public class TomaDecisionesServiceImpl implements TomaDecisionesService{

	@Autowired
	private TomaDecisionesRepository tomaDecisionesRepository;
	
	@Override
	public Iterable<TomadeDecisiones> findAll() {
		// TODO Auto-generated method stub
		return tomaDecisionesRepository.findAll();
	}

	@Override
	public Optional<TomadeDecisiones> findById(Integer id) {
		// TODO Auto-generated method stub
		return tomaDecisionesRepository.findById(id);
	}

	@Override
	public TomadeDecisiones save(TomadeDecisiones tomadeDecisiones) {
		// TODO Auto-generated method stub
		return tomaDecisionesRepository.save(tomadeDecisiones);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		tomaDecisionesRepository.deleteById(id);
	}

}
