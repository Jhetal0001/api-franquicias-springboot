package com.pruebas.gestorfranquicias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    private String id;
	private String nombre;
	private int stock;
}
