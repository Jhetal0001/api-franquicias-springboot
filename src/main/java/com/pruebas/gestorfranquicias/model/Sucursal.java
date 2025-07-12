package com.pruebas.gestorfranquicias.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sucursal {

    private String id;
	private String nombre;
    @Field("producto")
	private List<Producto> productos;
}
