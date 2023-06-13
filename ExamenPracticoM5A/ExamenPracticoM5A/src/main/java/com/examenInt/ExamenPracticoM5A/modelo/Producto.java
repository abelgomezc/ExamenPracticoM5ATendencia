/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenInt.ExamenPracticoM5A.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author Abel Gomez
 */

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(length = 100, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int cantidad;

    private double subTotal;
    private double descuento;
    private double iva;
    private double pvp;
    private double total;
   
 

    public void calcularValores() {
        subTotal = cantidad * precio;

        if (subTotal > 50) {
            descuento = subTotal * 0.1;
        } else {
            descuento = 0;
        }

        iva = subTotal * 0.12;
        pvp= precio+(precio*0.02);
        total = subTotal - descuento + iva;
    }
}

