package com.sertac.coffeeshop.service;

import com.sertac.coffeeshop.dao.ProductDAO;
import com.sertac.coffeeshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void delete(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productDAO.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
