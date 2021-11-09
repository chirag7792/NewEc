package com.example.ec.newec.dao;

import com.example.ec.newec.repo.Customer;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Data
public class CustomerRepo {

    @PersistenceContext
    private final EntityManager manager;

    public Customer create(Customer customer){
        manager.persist(customer);
        return customer;
    }
    public Customer update(Customer customer){
        return manager.merge(customer);
    }
    public Customer findOne(Long Id){
        return manager.find(Customer.class, Id);
    }
    public List<Customer> findall(){
        return manager.find(List.class, null );
    }
}
