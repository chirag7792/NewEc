package com.example.ec.newec;

import com.example.ec.newec.dao.CustRepo;
import com.example.ec.newec.repo.Address;
import com.example.ec.newec.repo.AddressType;
import com.example.ec.newec.repo.Customer;
import com.example.ec.newec.repo.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class NewEcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NewEcApplication.class, args);
        CustRepo repo = context.getBean(CustRepo.class);
        log.info("finding customer with id -> {}",repo.findById(100L));
//        Address address = Address.builder()
//                .streetNo(16).streetName("lesskim").city("Scarborough").state("on").zip("m1w3t7").addressType(AddressType.HOME)
//                .build();
//        repo.save(Customer.builder().status(Status.NEW).Id(1011l).firstName("nick").lastName("jad")
//                .createDate(new Date()).updateDate(new Date()).address(address).build());
        log.info("all customers -> [{}]", repo.findAll());
//        CustomerRepo repo = context.getBean(CustomerRepo.class);
//
//        Customer customer = Customer.builder()
//                .Id(1002L).firstName("nick").lastName("jack").createDate(new Date()).updateDate(new Date())
//                .build();
//        repo.create(customer);
//        System.out.println(repo.findOne(100L));
    }

}
