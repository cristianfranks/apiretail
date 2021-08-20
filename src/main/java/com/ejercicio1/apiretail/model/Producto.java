package com.ejercicio1.apiretail.model;
import lombok.*;

@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto {
    private String id;
    private String nombre;
    private String detalle;
    private String precio;
    private String categoria;
}
