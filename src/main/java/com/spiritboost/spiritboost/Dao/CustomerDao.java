package com.spiritboost.spiritboost.Dao;

import com.spiritboost.spiritboost.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {

    @Query(value = "from Customer ")
    public List<Customer> getList();


    @Query(value = "select c from Customer c where c.Id = ?1")
    public Optional<Customer> findCustomerById(Long id);
}
