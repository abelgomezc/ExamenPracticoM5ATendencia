/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examenInt.ExamenPracticoM5A.repository;

import com.examenInt.ExamenPracticoM5A.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Abel Gomez
 */
public interface ProductoRepository   extends JpaRepository<Producto, Integer> {
    
}
