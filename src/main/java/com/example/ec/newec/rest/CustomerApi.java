package com.example.ec.newec.rest;

import com.example.ec.newec.dto.CustomerDto;
import com.example.ec.newec.dto.ErrorResponse;
import com.example.ec.newec.repo.Customer;
import com.example.ec.newec.repo.Status;
import com.example.ec.newec.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerApi {
    private final CustomerService service;

    @GetMapping
    public ResponseEntity<?> getAllCustomer(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-app", String.valueOf(service.getAllCustomerByStatus(Status.NEW).size()));
        headers.add("Author", "Harry");
        if(service.getAllCustomerByStatus(Status.NEW).size()==0){
            ErrorResponse response = ErrorResponse.builder().errCode("404 Not found")
                    .errDesc("Customer not found").dateTime(Instant.now()).build();
            return new ResponseEntity<>(response, headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getAllCustomerByStatus(Status.NEW),headers,HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<?> add(@RequestHeader("add") boolean add, @RequestBody CustomerDto customerDto){
        if(add){
            return ResponseEntity.accepted().body(service.addCustomer(customerDto));
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(customerDto);
    }
    @PutMapping
    public CustomerDto update(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        service.deleteCustomer(id);
    }

}
