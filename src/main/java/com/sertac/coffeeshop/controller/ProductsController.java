package com.sertac.coffeeshop.controller;

import com.sertac.coffeeshop.dao.ProductDAO;
import com.sertac.coffeeshop.entity.Product;
import com.sertac.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    //Save Product
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productsList(@ModelAttribute("product") Product product, Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "products";
    }

    @PostMapping("/saveproduct")
    public String saveProduct(Product product) {
        Product product1 = product;
        productService.save(product1);
        return "redirect:/products";
    }
    //!----------

    //Update Product
    @RequestMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productService.findById(id));
        return "products";
    }

    @PostMapping("/updateproduct/{id}")
    public String updateProduct(Product product, @PathVariable Long id) {
        product.setProductId(id);
        productService.save(product);
        return "redirect:/products";
    }
    //!----------

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }

}