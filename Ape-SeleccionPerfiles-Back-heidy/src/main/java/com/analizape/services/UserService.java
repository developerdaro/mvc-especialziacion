package com.analizape.services;

import java.util.Optional;

import com.analizape.models.user;

public interface UserService {

	public Iterable <user> findAll();
	public Optional<user> findById(Integer id);
	public user save(user user);
	public void deleteById(Integer id);
	
}
