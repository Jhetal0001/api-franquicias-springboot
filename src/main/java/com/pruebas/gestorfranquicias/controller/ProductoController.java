package com.pruebas.gestorfranquicias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.gestorfranquicias.model.Producto;
import com.pruebas.gestorfranquicias.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PutMapping("/{id}/stock")
	public ResponseEntity<Producto> actualizarStock(@PathVariable String id, @RequestParam int stock) {
		Producto productoActualizado = productoService.actualizarStock(id, stock);
		return productoActualizado != null ? ResponseEntity.ok(productoActualizado) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarNombreProducto(@PathVariable String id, @RequestBody String nuevoNombre) {
        Producto productoActualizado = productoService.actualizarNombreProducto(id, nuevoNombre);
        return productoActualizado != null ? ResponseEntity.ok(productoActualizado) : ResponseEntity.notFound().build();
    }
}
