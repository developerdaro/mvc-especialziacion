package com.analizape.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepcion extends RuntimeException {

	private static final long serialVersionID = 1L;

	public ResourceNotFoundExcepcion(String mensaje) {

		super(mensaje);

	}

}
