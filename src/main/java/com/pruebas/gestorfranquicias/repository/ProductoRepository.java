package com.pruebas.gestorfranquicias.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.gestorfranquicias.model.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String> {

	/**
	 * Buscar productos por nombre <br>
	 * 
	 * @param nombre
	 * @return
	 */
	List<Producto> findByNombre(String nombre);

	/**
	 * Buscar productos con stock mayor a cierto valor <br>
	 * 
	 * @param stock
	 * @return
	 */
	List<Producto> findByStockGreaterThan(int stock);
}