/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenInt.ExamenPracticoM5A.controller;

import com.examenInt.ExamenPracticoM5A.modelo.Producto;
import com.examenInt.ExamenPracticoM5A.service.ProductoServiceImpl;

import java.lang.reflect.Array;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Abel Gomez
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    // @Operation(summary = "Se obtiene la lista de Productos")
    @GetMapping("/listarProducto")
    public ResponseEntity<List<Producto>> listaProducto() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/subirProducto")
    public ResponseEntity<Producto> subirProducto(@RequestBody Producto producto) {

        producto.calcularValores();
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizarProducto/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto u) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            try {

                producto.setDescripcion(u.getDescripcion());
                producto.setPrecio(u.getPrecio());
                producto.setCantidad(u.getCantidad());
                producto.calcularValores();

                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<Producto> elimiarProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


