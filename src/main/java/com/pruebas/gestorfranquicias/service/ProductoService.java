package com.pruebas.gestorfranquicias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.gestorfranquicias.model.Producto;
import com.pruebas.gestorfranquicias.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	/**
	 * Actualizar el stock de un producto <br>
	 * 
	 * @param productoId
	 * @param stock
	 * @return
	 */
	public Producto actualizarStock(String productoId, int stock) {
		Producto producto = productoRepository.findById(productoId).orElse(null);
		if (producto != null) {
			producto.setStock(stock);
			return productoRepository.save(producto); // Guardar el producto con el nuevo stock
		}
		return null;
	}

	/**
	 * Actualizar el nombre de un producto <br>
	 * 
	 * @param productoId
	 * @param nuevoNombre
	 * @return
	 */
	public Producto actualizarNombreProducto(String productoId, String nuevoNombre) {
		Producto producto = productoRepository.findById(productoId).orElse(null);
		if (producto != null) {
			producto.setNombre(nuevoNombre);
			return productoRepository.save(producto);
		}
		return null;
	}
}
