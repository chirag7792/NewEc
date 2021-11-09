package com.example.ec.newec.dao;

import com.example.ec.newec.repo.Customer;
import com.example.ec.newec.repo.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustRepo extends JpaRepository<Customer, Long> {

    List<Customer> getAllByStatus(Status status);
    int countByStatus(Status status);

    @Query("Select c from Customer c where c.Id = :id")
    Optional<Customer> getCustomer(@Param("id") Long id);

    @Query(value = "Select count(*) from table_customer", nativeQuery = true)
    int getMyAllCount();
    @Query("Select c from Customer c, Product  p where c.products.size> 0 and c.Id= :id")
    Optional<Customer> getCustomerWithProduct(@Param("id") Long id);

    List<Customer> findAllByLastName(String lastName);

    List<Customer> findAllByFirstName(String firstName);

    List<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);
}
