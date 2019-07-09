package com.sertac.coffeeshop.service;

import com.sertac.coffeeshop.dao.CustomerDAO;
import com.sertac.coffeeshop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerDAO.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

}
