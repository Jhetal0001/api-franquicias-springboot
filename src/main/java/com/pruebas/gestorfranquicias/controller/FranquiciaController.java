package com.pruebas.gestorfranquicias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.gestorfranquicias.model.Franquicia;
import com.pruebas.gestorfranquicias.model.Producto;
import com.pruebas.gestorfranquicias.model.Sucursal;
import com.pruebas.gestorfranquicias.service.FranquiciaService;
import com.pruebas.gestorfranquicias.service.SucursalService;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

	@Autowired
	private FranquiciaService franquiciaService;

	@Autowired
	private SucursalService sucursalService;

	@PostMapping
	public ResponseEntity<Franquicia> agregarFranquicia(@RequestBody Franquicia franquicia) {
		Franquicia nuevaFranquicia = franquiciaService.agregarFranquicia(franquicia);
		return ResponseEntity.status(201).body(nuevaFranquicia);
	}

	@PostMapping("/{id}/sucursales")
	public ResponseEntity<Sucursal> agregarSucursal(@PathVariable String id, @RequestBody Sucursal sucursal) {
		Sucursal nuevaSucursal = sucursalService.agregarSucursalAFranquicia(id, sucursal);
		return ResponseEntity.status(201).body(nuevaSucursal);
	}

	@GetMapping("/{id}/productos/mayor-stock")
	public ResponseEntity<Producto> obtenerProductoConMayorStock(@PathVariable String id) {
		Producto productoConMayorStock = franquiciaService.obtenerProductoConMayorStock(id);
		return productoConMayorStock != null ? ResponseEntity.ok(productoConMayorStock)
				: ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Franquicia> actualizarNombreFranquicia(@PathVariable String id,
			@RequestBody String nuevoNombre) {
		Franquicia franquiciaActualizada = franquiciaService.actualizarNombreFranquicia(id, nuevoNombre);
		return franquiciaActualizada != null ? ResponseEntity.ok(franquiciaActualizada)
				: ResponseEntity.notFound().build();
	}
}
