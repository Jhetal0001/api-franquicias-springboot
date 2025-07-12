package com.pruebas.gestorfranquicias.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Franquicia {
	
	@Id
    private String id;
	private String nombre;
    @Field("sucursales")
	private List<Sucursal> sucursales;

}
