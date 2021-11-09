package com.example.ec.newec.service;

import com.example.ec.newec.dto.CustomerDto;
import com.example.ec.newec.repo.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerDto customerDto){
        return Customer.builder()
                .Id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .status(customerDto.getStatus())
                .build();

    }

    public CustomerDto toCustomerDto(Customer customer){
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .LastName(customer.getLastName())
                .status(customer.getStatus())
        .build();
    }
}
