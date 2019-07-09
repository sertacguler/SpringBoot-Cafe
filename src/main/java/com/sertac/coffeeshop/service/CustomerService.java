package com.sertac.coffeeshop.service;

import com.sertac.coffeeshop.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    void delete(Long id);

    List<Customer> findAll();

}
