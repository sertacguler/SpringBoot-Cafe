package com.sertac.coffeeshop.controller;

import com.sertac.coffeeshop.dao.CustomerDAO;
import com.sertac.coffeeshop.dao.OrderDAO;
import com.sertac.coffeeshop.dao.ProductDAO;
import com.sertac.coffeeshop.entity.Customer;
import com.sertac.coffeeshop.entity.CustomerOrder;
import com.sertac.coffeeshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class OrderListController {

    @Autowired
    private ProductDAO productRepository;

    @Autowired
    private OrderDAO orderRepository;

    @Autowired
    private CustomerDAO customerRepository;

    @RequestMapping(value = "/orderlist", method = RequestMethod.GET)
    public String productsList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("ordery", orderRepository.findAll());
        return "orderlist";
    }

    @GetMapping("/complateorder/{id}")
    public String complateOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "redirect:/orderlist";
    }

}