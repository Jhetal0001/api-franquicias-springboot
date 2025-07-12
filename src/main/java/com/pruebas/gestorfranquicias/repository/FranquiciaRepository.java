package com.pruebas.gestorfranquicias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.gestorfranquicias.model.Franquicia;

@Repository
public interface FranquiciaRepository extends MongoRepository<Franquicia, String> {

	/**
	 * Permite buscar una franquicia por nombre <br>
	 * 
	 * @param nombre
	 * @return
	 */
	Franquicia findByNombre(String nombre);
}
