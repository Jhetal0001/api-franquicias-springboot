package com.pruebas.gestorfranquicias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.gestorfranquicias.model.Franquicia;
import com.pruebas.gestorfranquicias.model.Producto;
import com.pruebas.gestorfranquicias.model.Sucursal;
import com.pruebas.gestorfranquicias.repository.FranquiciaRepository;

@Service
public class FranquiciaService {

	@Autowired
	private FranquiciaRepository franquiciaRepository;

	/**
	 * Agregar una nueva franquicia <br>
	 * 
	 * @param franquicia
	 * @return
	 */
	public Franquicia agregarFranquicia(Franquicia franquicia) {
		return franquiciaRepository.save(franquicia);
	}

	/**
	 * Obtener una franquicia por nombre <br>
	 * 
	 * @param nombre
	 * @return
	 */
	public Franquicia obtenerFranquiciaPorNombre(String nombre) {
		return franquiciaRepository.findByNombre(nombre);
	}

	/**
	 * Obtener el producto con más stock por sucursal para una franquicia específica
	 * <br>
	 * 
	 * @param franquiciaId
	 * @return
	 */
	public Producto obtenerProductoConMayorStock(String franquiciaId) {
		Franquicia franquicia = franquiciaRepository.findById(franquiciaId).orElse(null);
		if (franquicia != null) {
			Producto productoConMayorStock = null;
			for (Sucursal sucursal : franquicia.getSucursales()) {
				for (Producto producto : sucursal.getProductos()) {
					if (productoConMayorStock == null || producto.getStock() > productoConMayorStock.getStock()) {
						productoConMayorStock = producto;
					}
				}
			}
			return productoConMayorStock;
		}
		return null;
	}

	/**
	 * Actualizar el nombre de una franquicia <br>
	 * 
	 * @param franquiciaId
	 * @param nuevoNombre
	 * @return
	 */
	public Franquicia actualizarNombreFranquicia(String franquiciaId, String nuevoNombre) {
		Franquicia franquicia = franquiciaRepository.findById(franquiciaId).orElse(null);
		if (franquicia != null) {
			franquicia.setNombre(nuevoNombre);
			return franquiciaRepository.save(franquicia);
		}
		return null;
	}
}
