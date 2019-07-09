package com.sertac.coffeeshop.dao;

import com.sertac.coffeeshop.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends CrudRepository<CustomerOrder, Long> {

}