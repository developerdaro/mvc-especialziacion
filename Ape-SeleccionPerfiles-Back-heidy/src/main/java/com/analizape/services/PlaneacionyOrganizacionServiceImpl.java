package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Planeacion_organizacion;
import com.analizape.repository.PlaneacionOrganizacionRepository;
import com.analizape.repository.RolRepository;

@Service
public class PlaneacionyOrganizacionServiceImpl implements PlaneacionyOrganizacionService{

	@Autowired
	private PlaneacionOrganizacionRepository planeacionOrganizacionRepository;
	
	@Override
	public Iterable<Planeacion_organizacion> findAll() {
		// TODO Auto-generated method stub
		return planeacionOrganizacionRepository.findAll();
	}

	@Override
	public Optional<Planeacion_organizacion> findById(Integer id) {
		// TODO Auto-generated method stub
		return planeacionOrganizacionRepository.findById(id);
	}

	@Override
	public Planeacion_organizacion save(Planeacion_organizacion planeacion_organizacion) {
		// TODO Auto-generated method stub
		return planeacionOrganizacionRepository.save(planeacion_organizacion);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		planeacionOrganizacionRepository.deleteById(id);
	}

}
