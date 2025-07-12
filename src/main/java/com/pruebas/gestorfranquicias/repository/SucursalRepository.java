package com.pruebas.gestorfranquicias.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.gestorfranquicias.model.Sucursal;

@Repository
public interface SucursalRepository extends MongoRepository<Sucursal, String> {

	/**
	 * Permite buscar una sucursal por nombre <br>
	 * 
	 * @param nombre
	 * @return
	 */
	List<Sucursal> findByNombre(String nombre);
}