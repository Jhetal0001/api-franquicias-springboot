package com.pruebas.gestorfranquicias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.gestorfranquicias.model.Producto;
import com.pruebas.gestorfranquicias.model.Sucursal;
import com.pruebas.gestorfranquicias.service.SucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;

	@PostMapping("/{id}/productos")
	public ResponseEntity<Producto> agregarProductoASucursal(@PathVariable String id, @RequestBody Producto producto) {
		Producto nuevoProducto = sucursalService.agregarProductoAUnaSucursal(id, producto);
		return ResponseEntity.status(201).body(nuevoProducto);
	}

	@DeleteMapping("/{id_sucursal}/productos/{id_producto}")
	public ResponseEntity<Void> eliminarProductoDeSucursal(@PathVariable String id_sucursal,
			@PathVariable String id_producto) {
		boolean eliminado = sucursalService.eliminarProductoDeSucursal(id_sucursal, id_producto);
		return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Sucursal> actualizarNombreSucursal(@PathVariable String id, @RequestBody String nuevoNombre) {
        Sucursal sucursalActualizada = sucursalService.actualizarNombreSucursal(id, nuevoNombre);
        return sucursalActualizada != null ? ResponseEntity.ok(sucursalActualizada) : ResponseEntity.notFound().build();
    }
}
