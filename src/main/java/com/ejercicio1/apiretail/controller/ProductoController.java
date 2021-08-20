package com.ejercicio1.apiretail.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ejercicio1.apiretail.model.Producto;


@RestController
@RequestMapping(value ="api/producto", produces ="application/json")

public class ProductoController {
    private Map<String,Producto> productos;

    public ProductoController(){
        productos = new HashMap<String,Producto>();
        Producto p = new Producto();
        p.setNombre("Nombre");
        p.setDetalle("Detalle Producto");
        p.setPrecio("00.00");
        p.setCategoria("Electrodomestico");
        String id = UUID.randomUUID().toString();
        p.setId(id);
        productos.put(id,p);
}

@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Map<String,Producto>> all(){
    return new ResponseEntity<Map<String,Producto>>(productos,HttpStatus.OK);
}



@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody Producto p){
        String id =UUID.randomUUID().toString();
        p.setId(id);
        productos.put(id, p);
        return  new ResponseEntity<String>(id,
        HttpStatus.CREATED);

}
@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> find(@PathVariable String id){
        if(productos.containsKey(id)){
            Producto p = productos.get(id);
            return new ResponseEntity<Producto>(p, HttpStatus.OK);
        }else{
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
}
