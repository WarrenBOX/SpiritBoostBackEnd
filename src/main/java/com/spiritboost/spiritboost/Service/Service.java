package com.spiritboost.spiritboost.Service;

import com.spiritboost.spiritboost.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface Service {

    public void saveUser(Customer customer);

    List<Customer> getUserList();

    Optional<Customer> getUserById(Long id);

    void updateCustomer(Long id, Customer customer);

    void deteleCustomer(Long id);
}
