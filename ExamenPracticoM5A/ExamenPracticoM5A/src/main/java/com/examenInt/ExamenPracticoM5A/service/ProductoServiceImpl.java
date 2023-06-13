/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examenInt.ExamenPracticoM5A.service;

import com.examenInt.ExamenPracticoM5A.modelo.Producto;
import com.examenInt.ExamenPracticoM5A.repository.ProductoRepository;
import org.aspectj.lang.annotation.AdviceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Abel Gomez
 */
@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements GenericService<Producto, Integer> {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoRepository;
    }
}
