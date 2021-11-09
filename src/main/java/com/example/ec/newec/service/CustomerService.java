package com.example.ec.newec.service;

import com.example.ec.newec.dao.CustRepo;
import com.example.ec.newec.dto.CustomerDto;
import com.example.ec.newec.repo.Customer;
import com.example.ec.newec.repo.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustRepo repo;
    private final CustomerMapper mapper;

    public CustomerDto addCustomer(CustomerDto customerDto){
        return mapper.toCustomerDto(repo.save(mapper.toCustomer(customerDto)));
    }
    public CustomerDto updateCustomer(Customer customer){
        return mapper.toCustomerDto(repo.save(customer));
    }
    public void deleteCustomer(Long id){
        repo.deleteById(id);
    }
    
    public List<Customer> getAllCustomerByFirstNameAndLastName(String firstName, String lastName){
        if(firstName==null && lastName==null){
            return repo.findAll();
        }
        if(firstName==null && lastName!=null){
            return repo.findAllByLastName(lastName);
        }
        if(firstName!=null && lastName==null){
            return repo.findAllByFirstName(firstName);
        }
        return repo.findAllByFirstNameAndLastName(firstName, lastName);
    };


    public List<Customer> getAllCustomerByStatus(Status status){
        return repo.getAllByStatus(status);
    }

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return repo.findById(id);
    }
}
