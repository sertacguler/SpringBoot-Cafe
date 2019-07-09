package com.sertac.coffeeshop.controller;

import com.sertac.coffeeshop.dao.CustomerDAO;
import com.sertac.coffeeshop.dao.OrderDAO;
import com.sertac.coffeeshop.dao.ProductDAO;
import com.sertac.coffeeshop.entity.Customer;
import com.sertac.coffeeshop.entity.CustomerOrder;
import com.sertac.coffeeshop.entity.Product;
import com.sertac.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class OrdersController {

    @Autowired
    private ProductDAO productRepository;

    @Autowired
    private OrderDAO orderRepository;

    @Autowired
    private CustomerDAO customerRepository;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String productsList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("ordery", orderRepository.findAll());
        return "orders";
    }

    @RequestMapping(value = "/createorder", method = RequestMethod.POST)
    public String saveOrder(@RequestParam String firstName, @RequestParam String detail, @RequestParam String size, @RequestParam(value = "productIds[]") Long[] productIds) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setDetail(detail);
        customer.setSize(size);
        customerRepository.save(customer);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customerRepository.findById(customer.getCustomerId()).get());
        Set<Product> productSet = new HashSet<Product>();
        for (Long productId : productIds) {
            productSet.add(productRepository.findById(productId).get());
        }
        customerOrder.setProducts(productSet);
        Double total = 0.0;
        for (Long productId : productIds) {
            total = total + (productRepository.findById(productId).get().getProductPrice());
        }
        customerOrder.setTotal(total);
        orderRepository.save(customerOrder);

        return "redirect:/orders";
    }

    @GetMapping("/removeorder/{id}")
    public String removeOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "redirect:/orders";
    }

}