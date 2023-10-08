package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Metas;
import com.analizape.repository.MetasRepository;

@Service
public class MetasServiceImpl implements MetasService {

	@Autowired
	private MetasRepository metasRepository;
	
	@Override
	public Iterable<Metas> findAll() {
		// TODO Auto-generated method stub
		return metasRepository.findAll();
	}

	@Override
	public Optional<Metas> findById(Integer id) {
		// TODO Auto-generated method stub
		return metasRepository.findById(id);
	}

	@Override
	public Metas save(Metas metas) {
		// TODO Auto-generated method stub
		return metasRepository.save(metas);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		metasRepository.deleteById(id);
	}

}
