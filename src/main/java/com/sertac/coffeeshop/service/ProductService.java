package com.sertac.coffeeshop.service;

import com.sertac.coffeeshop.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    void delete(Long id);

    Product findById(Long id);

    List<Product> findAll();

}
