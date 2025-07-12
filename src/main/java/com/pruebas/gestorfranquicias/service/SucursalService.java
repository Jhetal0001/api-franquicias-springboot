package com.pruebas.gestorfranquicias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.gestorfranquicias.model.Franquicia;
import com.pruebas.gestorfranquicias.model.Producto;
import com.pruebas.gestorfranquicias.model.Sucursal;
import com.pruebas.gestorfranquicias.repository.FranquiciaRepository;
import com.pruebas.gestorfranquicias.repository.SucursalRepository;

@Service
public class SucursalService {

	@Autowired
	private FranquiciaRepository franquiciaRepository;

	@Autowired
	private SucursalRepository sucursalRepository;

	/**
	 * Agregar una sucursal a una franquicia <br>
	 * 
	 * @param franquiciaId
	 * @param sucursal
	 * @return
	 */
	public Sucursal agregarSucursalAFranquicia(String franquiciaId, Sucursal sucursal) {
		Franquicia franquicia = franquiciaRepository.findById(franquiciaId).orElse(null);
		if (franquicia != null) {
			franquicia.getSucursales().add(sucursal);
			franquiciaRepository.save(franquicia); // Guardar la franquicia con la nueva sucursal
			return sucursal;
		}
		return null;
	}

	/**
	 * Agregar un producto a una sucursal <br>
	 * 
	 * @param sucursalId
	 * @param producto
	 * @return
	 */
	public Producto agregarProductoAUnaSucursal(String sucursalId, Producto producto) {
		Sucursal sucursal = sucursalRepository.findById(sucursalId).orElse(null);
		if (sucursal != null) {
			sucursal.getProductos().add(producto);
			sucursalRepository.save(sucursal); // Guardar la sucursal con el nuevo producto
			return producto;
		}
		return null;
	}

	/**
	 * Eliminar un producto de una sucursal <br>
	 * 
	 * @param sucursalId
	 * @param productoId
	 * @return
	 */
	public boolean eliminarProductoDeSucursal(String sucursalId, String productoId) {
		Sucursal sucursal = sucursalRepository.findById(sucursalId).orElse(null);
		if (sucursal != null) {
			Producto producto = sucursal.getProductos().stream().filter(p -> p.getId().equals(productoId)).findFirst()
					.orElse(null);
			if (producto != null) {
				sucursal.getProductos().remove(producto);
				sucursalRepository.save(sucursal); // Guardar la sucursal después de eliminar el producto
				return true;
			}
		}
		return false;
	}

	/**
	 * Actualizar el nombre de una sucursal <br>
	 * 
	 * @param sucursalId
	 * @param nuevoNombre
	 * @return
	 */
	public Sucursal actualizarNombreSucursal(String sucursalId, String nuevoNombre) {
		Sucursal sucursal = sucursalRepository.findById(sucursalId).orElse(null);
		if (sucursal != null) {
			sucursal.setNombre(nuevoNombre);
			return sucursalRepository.save(sucursal);
		}
		return null;
	}

}
